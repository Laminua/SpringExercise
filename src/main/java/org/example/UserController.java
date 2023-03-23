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

    String userNameToUpdateTemp;

    @RequestMapping("/addUser")
    public RedirectView addUsersToMap(@ModelAttribute("userProfile") UserProfile profile) {

        if (!profile.getName().equals("")) {
            accountService.getUsers().put(profile.getName(), profile.getEmail());
        }
        if (!profile.getName().equals(userNameToUpdateTemp)) {
            accountService.getUsers().remove(userNameToUpdateTemp);
            accountService.getUsers().put(profile.getName(), profile.getEmail());
        }
        return new RedirectView("/");
    }

    @RequestMapping("/deleteUser")
    public RedirectView deleteUserFromMap(@RequestParam("userNameToDelete") String name) {

        getAccountService().getUsers().remove(name);

        return new RedirectView("/");
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userNameToUpdate") String name, Model model) {

        UserProfile userProfile = new UserProfile();
        userProfile.setName(name);
        userProfile.setEmail(getAccountService().getUsers().get(name));
        model.addAttribute("userProfile", userProfile);
        userNameToUpdateTemp = name;

        return "add-user";
    }
}