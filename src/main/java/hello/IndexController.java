package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        LocalDate currentDate = LocalDate.now();
        addCalendarToModel(model, currentDate.getYear(), currentDate.getMonthValue());
        return "calendar";
    }

    private void addCalendarToModel(Model model, int year, int month) {
        List<List<Integer>> calendar = new ArrayList<>();
        Map<Integer, List<Event>> events = new HashMap<>();

        LocalDate date = LocalDate.of(year, month, 1);
        boolean zeroFilled = false;

        while(date.getMonthValue() == month) {
            List<Integer> row = new ArrayList<>();
            for(int dayOfWeek = 1; dayOfWeek < 8; dayOfWeek++) {
                int dateDayOfWeek = date.getDayOfWeek().getValue();

                if(dateDayOfWeek == dayOfWeek && date.getMonthValue() == month) {
                    row.add(date.getDayOfMonth());
                    events.put(date.getDayOfMonth(), getEvents(date));
                    zeroFilled = true;
                } else {
                    row.add(null);
                }

                if( zeroFilled) {
                    date = date.plusDays(1);
                }

                if(dayOfWeek % 7 == 0) {
                    calendar.add(row);
                    break;
                }
            }
        }

        model.addAttribute("calendar", calendar);
        model.addAttribute("events", events);

        LocalDate currDate = LocalDate.of(year, month, 1);
        model.addAttribute("date", Date.from(currDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    private List<Event> getEvents(LocalDate date) {
        return Database.get(date);
    }

    @RequestMapping(value = "/{year}-{month}", method = RequestMethod.GET)
    public String change(@PathVariable("year") int year, @PathVariable("month") int month, Model model){
        addCalendarToModel(model, year, month);
        return "calendar";
    }

}
