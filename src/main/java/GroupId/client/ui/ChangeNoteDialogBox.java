package GroupId.client.ui;

import GroupId.client.Subscriber;
import GroupId.client.SubscriberService;
import GroupId.client.SubscriberServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import java.util.ArrayList;
import java.util.Date;

public class ChangeNoteDialogBox extends AddNoteDialogBox {
    interface ChangeNoteDialogBoxUiBinder extends UiBinder<Widget, ChangeNoteDialogBox> {
    }
    private static ChangeNoteDialogBoxUiBinder changeNoteDialogBoxUiBinder = GWT.create(ChangeNoteDialogBoxUiBinder.class);
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
    public ChangeNoteDialogBox() {
        setWidget(changeNoteDialogBoxUiBinder.createAndBindUi(this));
        setText("Введите данные");
        setGlassEnabled(true);
        setAnimationEnabled(true);
    }
    @UiField
    Button applyButton;
    @UiHandler("applyButton")
    public void handleClickApply(ClickEvent event){
        Subscriber newSubscriber = new Subscriber(name.getText(),checkTelNumber(number.getText()),comment.getText(),new Date(),getId());
        subscriberServiceAsync.changeSubscriber(newSubscriber, new AsyncCallback<ArrayList<Subscriber>>() {
            @Override
            public void onFailure(Throwable caught) {
            }
            @Override
            public void onSuccess(ArrayList<Subscriber> result) {
                clean();
                hide();
                mainPanel.drawTable(result);
            }
        });
    }
    @Override
    public String checkTelNumber(String telNumber)throws IllegalArgumentException {
        String temp = telNumber.replaceAll("\\D","");
        StringBuilder stringBuilder = new StringBuilder(temp);
        String result = null;
        if(temp.isEmpty() ||
                temp.length() > 11 || temp.length() < 10) {
            throw new IllegalArgumentException();
        }
        else {
            if(temp.length() == 10) result = "+7"+temp.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
            if(temp.length() == 11 && temp.charAt(0) == '7') result = "+" + temp.replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d+)", "$1($2)-$3-$4");
            if(temp.length() == 11 && temp.charAt(0) == '8') result = "+7" + stringBuilder.substring(1).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        }
        return result;
    }
}