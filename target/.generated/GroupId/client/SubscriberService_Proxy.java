package GroupId.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class SubscriberService_Proxy extends RemoteServiceProxy implements GroupId.client.SubscriberServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "GroupId.client.SubscriberService";
  private static final String SERIALIZATION_POLICY ="C48BF7B08206E26B6496BEC520CB0F5F";
  private static final GroupId.client.SubscriberService_TypeSerializer SERIALIZER = new GroupId.client.SubscriberService_TypeSerializer();
  
  public SubscriberService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "greet", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void addSubscriber(GroupId.client.Subscriber newSubscriber, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "addSubscriber");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("GroupId.client.Subscriber/1982244274");
      streamWriter.writeObject(newSubscriber);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void changeSubscriber(GroupId.client.Subscriber newSubscriber, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "changeSubscriber");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("GroupId.client.Subscriber/1982244274");
      streamWriter.writeObject(newSubscriber);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void check(GroupId.client.Subscriber newSubscriber, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "check");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("GroupId.client.Subscriber/1982244274");
      streamWriter.writeObject(newSubscriber);
      helper.finish(async, ResponseReader.VOID);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void deleteSubscriber(java.util.ArrayList list, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "deleteSubscriber");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.ArrayList/4159755760");
      streamWriter.writeObject(list);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void filterSubscriberList(java.util.ArrayList list, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "filterSubscriberList");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.util.ArrayList/4159755760");
      streamWriter.writeObject(list);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void getSubscriberList(com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "getSubscriberList");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 0);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void request(java.lang.String ins, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "request");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(ins);
      helper.finish(async, ResponseReader.VOID);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void requestList(java.lang.String ins, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "requestList");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(ins);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  
  public void sortSubscriberList(java.lang.String text, com.google.gwt.user.client.rpc.AsyncCallback async) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SubscriberService_Proxy", "sortSubscriberList");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(text);
      helper.finish(async, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      async.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
