package com.professionalpractice.medicalbooking.dtos.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    String email;

    String fullName;

    String address;

    String phoneNumber;

    String gender;

    String dateOfBirth;

    @NotBlank(message = "Yêu cầu nhập mật khẩu")
    @Size(min = 7, message = "Mật khẩu cần nhiều hơn 7 kí tự")
    String password;

    String avatarUrl;

    Boolean isLocked;

    List<String> roles;
}
