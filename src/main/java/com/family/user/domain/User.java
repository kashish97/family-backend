package com.family.user.domain;

import com.family.user.utils.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String name;
    @NonNull
    @Indexed(unique = true)
    private String phone;
    @Indexed(unique = true)
    private String email;
    private String firebaseToken;
    private UserType userType;
    private Date loginTimeStamp;


}
