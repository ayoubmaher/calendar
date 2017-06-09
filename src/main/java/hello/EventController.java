package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/event")
public class EventController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Event> saveEvent(EventForm form) {
        System.out.printf("date: %s, title: %s, description: %s", form.getDate().toString(), form.getTitle(), form.getDescription());

        Event event = new Event(form.getDate(),form.getTitle(),form.getDescription());
        // add
        Database.add(event);
        return Database.getAll();
    }

    public void delete(int id){
        Database.remove(id);
    }

    public void modify(EventForm form){


    }



}
