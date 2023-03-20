package org.example.accounts;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DataBase {
    private Map<String, UserProfile> users;

    public DataBase() {
        users = new HashMap<String, UserProfile>();
        users.put("user1", new UserProfile());
        users.get("user1").setName("Vasya");
        users.get("user1").setEmail("Vasya@mail.ru");
        users.put("user2", new UserProfile());
        users.get("user2").setName("Vova");
        users.get("user2").setEmail("Vova@mail.ru");
    }
}
