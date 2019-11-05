package GroupId.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Subscriber_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getComment(GroupId.client.Subscriber instance) /*-{
    return instance.@GroupId.client.Subscriber::comment;
  }-*/;
  
  private static native void setComment(GroupId.client.Subscriber instance, java.lang.String value) 
  /*-{
    instance.@GroupId.client.Subscriber::comment = value;
  }-*/;
  
  private static native java.util.Date getDate(GroupId.client.Subscriber instance) /*-{
    return instance.@GroupId.client.Subscriber::date;
  }-*/;
  
  private static native void setDate(GroupId.client.Subscriber instance, java.util.Date value) 
  /*-{
    instance.@GroupId.client.Subscriber::date = value;
  }-*/;
  
  private static native int getId(GroupId.client.Subscriber instance) /*-{
    return instance.@GroupId.client.Subscriber::id;
  }-*/;
  
  private static native void setId(GroupId.client.Subscriber instance, int value) 
  /*-{
    instance.@GroupId.client.Subscriber::id = value;
  }-*/;
  
  private static native java.lang.String getName(GroupId.client.Subscriber instance) /*-{
    return instance.@GroupId.client.Subscriber::name;
  }-*/;
  
  private static native void setName(GroupId.client.Subscriber instance, java.lang.String value) 
  /*-{
    instance.@GroupId.client.Subscriber::name = value;
  }-*/;
  
  private static native java.lang.String getNumber(GroupId.client.Subscriber instance) /*-{
    return instance.@GroupId.client.Subscriber::number;
  }-*/;
  
  private static native void setNumber(GroupId.client.Subscriber instance, java.lang.String value) 
  /*-{
    instance.@GroupId.client.Subscriber::number = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, GroupId.client.Subscriber instance) throws SerializationException {
    setComment(instance, streamReader.readString());
    setDate(instance, (java.util.Date) streamReader.readObject());
    setId(instance, streamReader.readInt());
    setName(instance, streamReader.readString());
    setNumber(instance, streamReader.readString());
    
  }
  
  public static GroupId.client.Subscriber instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new GroupId.client.Subscriber();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, GroupId.client.Subscriber instance) throws SerializationException {
    streamWriter.writeString(getComment(instance));
    streamWriter.writeObject(getDate(instance));
    streamWriter.writeInt(getId(instance));
    streamWriter.writeString(getName(instance));
    streamWriter.writeString(getNumber(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return GroupId.client.Subscriber_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    GroupId.client.Subscriber_FieldSerializer.deserialize(reader, (GroupId.client.Subscriber)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    GroupId.client.Subscriber_FieldSerializer.serialize(writer, (GroupId.client.Subscriber)object);
  }
  
}
