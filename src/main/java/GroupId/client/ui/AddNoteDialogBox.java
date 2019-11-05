package GroupId.client.ui;

import GroupId.client.Subscriber;
import GroupId.client.SubscriberService;
import GroupId.client.SubscriberServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.Date;

public class AddNoteDialogBox extends DialogBox {
    interface AddNoteDialogBoxUiBinder extends UiBinder<Widget, AddNoteDialogBox> {
    }
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private static AddNoteDialogBoxUiBinder addNoteDialogBoxUiBinder = GWT.create(AddNoteDialogBoxUiBinder.class);
    private SubscriberServiceAsync subscriberServiceAsync = GWT.create(SubscriberService.class);
    @UiField
    TextBox name;
    @UiField
    TextBox number;
    @UiField
    TextArea comment;
    private MainPanel mainPanel;
    public void setMainPanel (MainPanel mainPanelInstance){
        mainPanel = mainPanelInstance;
    }
    public AddNoteDialogBox() {
        setWidget(addNoteDialogBoxUiBinder.createAndBindUi(this));
        setText("Введите данные");
        setGlassEnabled(true);
        setAnimationEnabled(true);
    }
    @UiField
    Button applyButton;
    @UiHandler("applyButton")
    public void handleClickApply(ClickEvent event){
        try {
            String strNum = checkTelNumber((number.getText()));
        Subscriber newSubscriber = new Subscriber(name.getText(),strNum,comment.getText(),new Date());
        subscriberServiceAsync.addSubscriber(newSubscriber, new AsyncCallback<ArrayList<Subscriber>>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("В базе уже есть указанный номер");
            }
            @Override
            public void onSuccess(ArrayList<Subscriber> result) {
                clean();
                hide();
                mainPanel.drawTable(result);
            }
        });
        }catch (IllegalArgumentException e){
            Window.alert("Неверный формат ввода номера!");
        }
    }

    @UiField
    Button cancelButton;
    @UiHandler("cancelButton")
    public void handleClickClose(ClickEvent event) {
        clean();
        hide();
    }
    public String checkTelNumber(String telNumber)throws IllegalArgumentException {
        StringBuilder stringBuilder = new StringBuilder(telNumber);
        String result = null;
        if(telNumber == null||
                telNumber.isEmpty() ||
                telNumber.matches("\\w")||
                telNumber.length() > 12 || telNumber.length() < 10) {
            throw new IllegalArgumentException();
        }
        else {
            if(telNumber.length() == 10) result = "+7"+telNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
            if(telNumber.length() == 11 && telNumber.charAt(0) == '7') result = "+" + telNumber.replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d+)", "$1($2)-$3-$4");
            if(telNumber.length() == 11 && telNumber.charAt(0) == '8') result = "+7" + stringBuilder.substring(1).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
            if(telNumber.length() == 12 && telNumber.charAt(0) == '+') result = "+7" + stringBuilder.substring(2).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        }
        return result;
    }
    public void clean() {
        name.setValue(null);
        number.setValue(null);
        comment.setValue(null);
    }
}