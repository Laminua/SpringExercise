package org.example.accounts;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Getter
public class AccountService {
    private Map<Integer, UserProfile> users = new HashMap<>();

    public void deleteUserById(int id) {
        users.remove(id);
    }

    public void addUser(UserProfile profile) {
        profile.setId(profile.hashCode());
        users.put(profile.getId(), profile);
    }

    public void updateUser(int id, UserProfile profile) {
        if (id == 0 || !users.containsKey(id)) {
            throw new IllegalArgumentException("Передан пустой ID, или пользователя с таким ID не существует");
        }
        users.replace(id, profile);
    }

    public UserProfile getUserById(int id) {
        return users.get(id);
    }
}
