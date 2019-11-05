package GroupId.client;

import java.io.Serializable;
import java.util.Date;
@SuppressWarnings("serial")
public class Subscriber implements Serializable {
    public Subscriber(){
    }

    public Subscriber(String name, String number, String comment, Date date, int id) {
        this.name = name;
        this.number = number;
        this.comment = comment;
        this.date = date;
        this.id = id;
    }
    public Subscriber(String name, String number, String comment, Date date) {
        this.name = name;
        this.number = number;
        this.comment = comment;
        this.date = date;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String name;
    private String number;
    private String comment;
    private Date date;

}
