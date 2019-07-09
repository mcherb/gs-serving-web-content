package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", "");
        model.addAttribute("customer", new Customer());

        return "greeting";
    }

    @PostMapping("/greeting")
    public String saveGreeting(Customer customer, Model model) {
        model.addAttribute("name", customer.getFirstName());
        return "greeting";
    }

}
