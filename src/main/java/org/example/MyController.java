package org.example;

import org.example.accounts.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    private Map<String, String> users = new HashMap<>();

    @RequestMapping("/")
    public String ShowUsers() {

        return "index";
    }

    @RequestMapping("/addUserForm")
    public String showAddUserForm(Model model) {

        model.addAttribute("userProfile", new UserProfile());

        return "add-user";
    }

    @RequestMapping("/addUser")
    public String addUsersToMap(@ModelAttribute("userProfile") UserProfile profile, Model model) {
        if (profile.getName() != null) {
            users.put(profile.getName(), profile.getEmail());
        }
        model.addAttribute("usersMap", users);

        return "index";
    }

}