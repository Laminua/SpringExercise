package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.accounts.AccountService;
import org.example.accounts.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@Getter
public class MyController {

    private final AccountService accountService;

    @RequestMapping("/")
    public String showUsers(Model model) {

        model.addAttribute("usersMap", getAccountService().getUsers());

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
            getAccountService().getUsers().put(profile.getName(), profile.getEmail());
        }
        return new RedirectView("/");
    }
}