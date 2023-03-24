package org.example.accounts;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Getter@Setter
public class AccountService {
    private Map<Integer, UserProfile> users = new HashMap<>();
}
