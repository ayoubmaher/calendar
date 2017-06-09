package hello;

import java.util.Date;

public class Event {
    private int id;
    private Date date;
    private String title;
    private String description;
    private static int count=0;

    public Event(Date date, String title, String description){
        id=count++;
        this.date=date;
        this.title=title;
        this.description=description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
