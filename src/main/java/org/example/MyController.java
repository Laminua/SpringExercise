package org.example;

import org.example.accounts.DataBase;
import org.example.accounts.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @RequestMapping("/addUser")
    public String showAddUserForm(Model model) {

        model.addAttribute("userProfile", new UserProfile());

        return "add-user";
    }

    @RequestMapping("/")
    public String showMainPage(@ModelAttribute("usersMap") DataBase users) {

        return "index";
    }
}
