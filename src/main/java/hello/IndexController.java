package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.System.out;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "calendar";
    }

    @RequestMapping(value = "/{year}-{month}", method = RequestMethod.GET)
    public String change(@PathVariable("year") int year, @PathVariable("month") int month){
        out.printf("year: %d, month: %d", year, month);
        return "calendar";
    }


}
