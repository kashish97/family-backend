package com.family.authentication.request;

import com.family.user.utils.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    private String name;
    @NonNull
    @Indexed(unique = true)
    private String phone;
    @Indexed(unique = true)
    private String email;
    private UserType userType;
    private Date loginTimeStamp;

}
