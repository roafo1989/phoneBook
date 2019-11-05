package GroupId.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface SubscriberServiceAsync {

    void request(String ins, AsyncCallback<Void> async);

    void check(Subscriber newSubscriber, AsyncCallback<Void> async);

    void requestList(String ins, AsyncCallback<ArrayList<Subscriber>> async);

    void getSubscriberList(AsyncCallback<ArrayList<Subscriber>> async);

    void addSubscriber(Subscriber newSubscriber, AsyncCallback<ArrayList<Subscriber>> async);

    void changeSubscriber(Subscriber newSubscriber, AsyncCallback<ArrayList<Subscriber>> async);

    void deleteSubscriber(ArrayList<Subscriber> list, AsyncCallback<ArrayList<Subscriber>> async);

    void sortSubscriberList(String text, AsyncCallback<ArrayList<Subscriber>> async);

    void filterSubscriberList(ArrayList<String> list, AsyncCallback<ArrayList<Subscriber>> async);
}
