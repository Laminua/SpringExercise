package org.example.accounts;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserProfile {
    private String name;
    private String email;

    public UserProfile() {
    }
}
