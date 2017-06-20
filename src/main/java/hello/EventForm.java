package hello;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class EventForm {
    private int id;
    private Date date;
    private String title;
    private String description;

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        try {
            this.date  = new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
        }
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
}
