package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.accounts.AccountService;
import org.example.accounts.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@Getter
public class UserController {

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

        if (profile.getName().equals("")) {
            return new RedirectView("/");
        }
        if (profile.getId() == 0) {
            profile.setId(profile.hashCode());
            getAccountService().getUsers().put(profile.getId(), profile);
        } else {
            getAccountService().getUsers().replace(profile.getId(), profile);
        }
        return new RedirectView("/");
    }

    @RequestMapping("/deleteUser")
    public RedirectView deleteUserFromMap(@RequestParam("userIdToDelete") int id) {

        getAccountService().getUsers().remove(id);

        return new RedirectView("/");
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userIdToUpdate") int id, Model model) {

        UserProfile userProfile = getAccountService().getUsers().get(id);
        model.addAttribute("userProfile", userProfile);

        return "add-user";
    }
}