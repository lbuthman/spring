package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Listing 5.3 HomeController: an example of an extremely simple controller
 */

@Controller
@RequestMapping({"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }
}
