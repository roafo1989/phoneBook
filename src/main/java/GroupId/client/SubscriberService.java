package GroupId.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

@RemoteServiceRelativePath("greet")
public interface SubscriberService extends RemoteService {
    ArrayList<Subscriber> getSubscriberList() throws IllegalArgumentException;
    ArrayList<Subscriber> addSubscriber(Subscriber  newSubscriber) throws IllegalArgumentException;
    ArrayList<Subscriber> changeSubscriber(Subscriber newSubscriber) throws IllegalArgumentException;
    ArrayList<Subscriber> deleteSubscriber(ArrayList<Subscriber> list) throws IllegalArgumentException;
    void request (String ins) throws IllegalArgumentException;
    void check(Subscriber newSubscriber) throws IllegalArgumentException;
    ArrayList<Subscriber> sortSubscriberList(String text) throws IllegalArgumentException;
    ArrayList<Subscriber> filterSubscriberList(ArrayList<String> list) throws IllegalArgumentException;
    ArrayList<Subscriber> requestList(String ins) throws IllegalArgumentException;

}
