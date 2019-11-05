package GroupId.client.ui;

import GroupId.client.PhoneBook;
import GroupId.client.Subscriber;
import GroupId.client.SubscriberService;
import GroupId.client.SubscriberServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainPanel extends Composite {
    interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {
    }
    private DateTimeFormat dateFormatSQL = DateTimeFormat.getFormat("yyyy-MM-dd");
    private static MainPanelUiBinder mainPanelUiBinder = GWT.create(MainPanelUiBinder.class);
    Logger remoteLogger = Logger.getLogger(PhoneBook.class.getSimpleName());
    private SubscriberServiceAsync subscriberServiceAsync = GWT.create(SubscriberService.class);
    private AddNoteDialogBox addNoteDialogBox;
    private ChangeNoteDialogBox changeNoteDialogBox;
    public void setAddNoteDialogBoxInstance(AddNoteDialogBox addNoteDialogBoxInstance){
        addNoteDialogBox = addNoteDialogBoxInstance;
    }
    public void setChangeNoteDialogBoxInstance(ChangeNoteDialogBox changeNoteDialogBoxInstance){
        changeNoteDialogBox = changeNoteDialogBoxInstance;
    }
    @UiField
    FlexTable stocksFlexTable;

    @UiField
    Button addNoteButton;
    @UiHandler("addNoteButton")
    void addClickHandler(ClickEvent event) {
        remoteLogger.log(Level.INFO, "addNoteButton clicked");
        remoteLogger.log(Level.INFO, "addNoteButton");
        GWT.log("test GWT log");
        addNoteDialogBox.center();
        addNoteDialogBox.show();
        addNoteDialogBox.name.setFocus(true);
    }

    @UiField
    Button deleteNoteButton;
    @UiHandler("deleteNoteButton")
    void deleteClickHandler(ClickEvent event){
        ArrayList<Subscriber> listForDelete = new ArrayList<>();
        ArrayList<Integer> rowForDelete = new ArrayList<>();
        for(int i = 1; i < stocksFlexTable.getRowCount(); i++) {
            CheckBox checkBox = (CheckBox) stocksFlexTable.getWidget(i, 0);
            if(checkBox.getValue()){
                String name = stocksFlexTable.getText(i,1);
                String num = stocksFlexTable.getText(i,2);
                String comment = stocksFlexTable.getText(i,3);
                Date date = dateFormatSQL.parse(stocksFlexTable.getText(i,4));
                Subscriber newSubscriber = new Subscriber(name,num,comment,date);
                listForDelete.add(newSubscriber);
                rowForDelete.add(i);
            }
        }
        subscriberServiceAsync.deleteSubscriber(listForDelete, new AsyncCallback<ArrayList<Subscriber>>() {
            @Override
            public void onFailure(Throwable caught) {
            }
            @Override
            public void onSuccess(ArrayList<Subscriber> result) {
                drawTable(result);
            }
        });
    }

    public MainPanel() {
        initWidget(mainPanelUiBinder.createAndBindUi(this));
        subscriberServiceAsync.getSubscriberList(new AsyncCallback<ArrayList<Subscriber>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("ERROR");
            }

            @Override
            public void onSuccess(ArrayList<Subscriber> result) {
                drawTable(result);
            }
        });
    }

    public void drawTable(ArrayList<Subscriber> result){
        stocksFlexTable.removeAllRows();
        drawTableHeader();
        drawTableBody(result);
    }
    public void drawTableHeader(){
        stocksFlexTable.setWidget(0,0,new Image("images/delete.jpg"));
        stocksFlexTable.setText(0, 1, "Имя");
        stocksFlexTable.setText(0, 2, "Телефон");
        stocksFlexTable.setText(0, 3, "Комментарий");
        stocksFlexTable.setText(0, 4, "Изменено");
        stocksFlexTable.setText(0, 5, "Ред.");
        stocksFlexTable.setCellPadding(6);
        stocksFlexTable.getRowFormatter().addStyleName(0, "tableHeader");
    }
    public void drawTableBody(ArrayList<Subscriber> result){
        int i = 1;
        for(Subscriber subscriber : result){
            stocksFlexTable.getRowFormatter().addStyleName(i,"row");
            CheckBox checkBox = new CheckBox();
            stocksFlexTable.setWidget(i,0,checkBox);
            stocksFlexTable.setText(i,1, subscriber.getName());
            stocksFlexTable.setText(i,2, subscriber.getNumber());
            stocksFlexTable.setText(i,3, subscriber.getComment());
            stocksFlexTable.setText(i,4,dateFormatSQL.format(subscriber.getDate()));
            Button changeButton = new Button();
            changeButton.setStyleName("change_button");
            stocksFlexTable.setWidget(i,5,changeButton);
            changeButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    setChanger(subscriber);
                }
            });
            i++;
        }
        setClickHandler(result);
    }
    public void sortTable(String sortRequest) {
        subscriberServiceAsync.sortSubscriberList(sortRequest, new AsyncCallback<ArrayList<Subscriber>>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ArrayList<Subscriber> result) {
                drawTable(result);
            }
        });
    }
    public void filterTable(ArrayList<String> listForSort){
        subscriberServiceAsync.filterSubscriberList(listForSort, new AsyncCallback<ArrayList<Subscriber>>() {
            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(ArrayList<Subscriber> result) {
                drawTable(result);
            }
        });
    }
    private void setClickHandler(ArrayList<Subscriber> result){
        stocksFlexTable.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                int rowIndex = stocksFlexTable.getCellForEvent(event).getRowIndex();
                int cellIndex = stocksFlexTable.getCellForEvent(event).getCellIndex();
                if(rowIndex != 0 && cellIndex != 0 && cellIndex != 5){
                    setChanger(result.get(rowIndex-1));
                }
            }
        });
    }
    private void setChanger(Subscriber subscriber){
        changeNoteDialogBox.center();
        changeNoteDialogBox.show();
        changeNoteDialogBox.setId(subscriber.getId());
        changeNoteDialogBox.setText("Изменить " + subscriber.getName());
        changeNoteDialogBox.name.setText(subscriber.getName());
        changeNoteDialogBox.name.setFocus(true);
        changeNoteDialogBox.name.selectAll();
        changeNoteDialogBox.number.setText(subscriber.getNumber());
        changeNoteDialogBox.comment.setText(subscriber.getComment());
    }
}