package GroupId.server;

import GroupId.client.Subscriber;
import GroupId.client.SubscriberService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SubscriberServiceImpl extends RemoteServiceServlet implements SubscriberService {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/phonebook?autoReconnet=true&useSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static Connection connection;
    static Statement statement;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public ArrayList<Subscriber> addSubscriber(Subscriber newSubscriber) throws IllegalArgumentException{
        check(newSubscriber);
        String requestToMySQL = String.format("INSERT INTO phonelist(phonelist_name, phonelist_number, phonelist_comment, phonelist_update) VALUES ('%s', '%s', '%s', '%s')", newSubscriber.getName(), newSubscriber.getNumber(), newSubscriber.getComment(),dateFormat.format(newSubscriber.getDate()));
        request(requestToMySQL);
        return getSubscriberList();
    }
    @Override
    public ArrayList<Subscriber> changeSubscriber(Subscriber newSubscriber) throws IllegalArgumentException{
        String requestToMySQL = String.format("UPDATE phonelist SET phonelist_name = '%s', phonelist_number = '%s', phonelist_comment = '%s', phonelist_update = '%s' WHERE phonelist_id = '%d'", newSubscriber.getName(), newSubscriber.getNumber(), newSubscriber.getComment(),dateFormat.format(newSubscriber.getDate()), newSubscriber.getId());
        request(requestToMySQL);
        return getSubscriberList();
    }
    @Override
    public ArrayList<Subscriber> deleteSubscriber(ArrayList<Subscriber> list) throws IllegalArgumentException {
        for (Subscriber newSubscriber : list) {
            String requestToMySQL = String.format("DELETE FROM phonelist WHERE phonelist_name = '%s'", newSubscriber.getName());
            request(requestToMySQL);
        }
        return getSubscriberList();
    }
    @Override
    public void request (String requestToMySQL) throws IllegalArgumentException{
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate(requestToMySQL);
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void check(Subscriber newSubscriber) throws IllegalArgumentException{
        String requestToMySQL = String.format("SELECT * FROM phonelist WHERE phonelist_name = '%s' OR phonelist_number = '%s'", newSubscriber.getName(), newSubscriber.getNumber());
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(requestToMySQL);
            if (resultSet.next()) {
               throw new IllegalArgumentException();
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public ArrayList<Subscriber> sortSubscriberList(String text) throws IllegalArgumentException {
        String requestToMySQL;
        if(text.equals("а-я")){
            requestToMySQL = "SELECT * FROM phonelist ORDER BY phonelist_name";
        }
        else{
            requestToMySQL = "SELECT * FROM phonelist ORDER BY phonelist_name DESC";
        }
        return requestList(requestToMySQL);
    }
    @Override
    public ArrayList<Subscriber> filterSubscriberList(ArrayList<String> list) throws IllegalArgumentException {
        String requestToMySQL = null;
        for(String s : list) {
            requestToMySQL = "select * from phonelist WHERE phonelist_name like '" + s +"%'" ;
        }
        return requestList(requestToMySQL);
    }
    @Override
    public ArrayList<Subscriber> getSubscriberList() throws IllegalArgumentException {
        String requestToMySQL = "select * from phonelist";
        return requestList(requestToMySQL);
    }
    @Override
    public ArrayList<Subscriber> requestList(String ins) throws IllegalArgumentException{
        ArrayList<Subscriber> subscriberList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(ins);
            while (resultSet.next()) {
                int id = resultSet.getInt("phonelist_id");
                String name = resultSet.getString("phonelist_name");
                String number = resultSet.getString("phonelist_number");
                String comment = resultSet.getString("phonelist_comment");
                Date date = resultSet.getDate("phonelist_update");
                subscriberList.add(new Subscriber(name, number, comment, date, id));
            }
            statement.close();
            connection.close();
            return subscriberList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
