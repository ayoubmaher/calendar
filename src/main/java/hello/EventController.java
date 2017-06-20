package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/event")
public class EventController {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Event> save(EventForm form) {
        Event event = new Event(form.getDate(),form.getTitle(),form.getDescription());
        Database.add(event);
        return Database.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@RequestParam("id") int id) {
        Database.remove(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete2(@PathVariable("id") int id){
        Database.remove(id);
    }

    public void modify(EventForm form){
        Event event = new Event(form.getDate(),form.getTitle(),form.getDescription());
        Database.modify(event);

    }
}
