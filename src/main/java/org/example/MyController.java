package org.example;

import org.example.accounts.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    private Map<String, String> users = new HashMap<>();

    @RequestMapping("/")
    public String showUsers(Model model) {

        model.addAttribute("usersMap", users);

        return "index";
    }

    @RequestMapping("/addUserForm")
    public String showAddUserForm(Model model) {

        model.addAttribute("userProfile", new UserProfile());

        return "add-user";
    }

    @RequestMapping("/addUser")
    public RedirectView addUsersToMap(@ModelAttribute("userProfile") UserProfile profile) {
        if (profile.getName() != null) {
            users.put(profile.getName(), profile.getEmail());
        }
        return new RedirectView("/");
    }
}