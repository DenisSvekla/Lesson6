package models;

import lombok.*;

@Data
@Builder
@ToString(exclude = "UUID")
public class User {
    private String email;
    private String password;
    private int UUID;
}
