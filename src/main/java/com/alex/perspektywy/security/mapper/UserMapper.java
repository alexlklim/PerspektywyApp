package com.alex.perspektywy.security.mapper;

import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.domain.dto.RegisterDto;
import com.alex.perspektywy.security.domain.dto.UserDto;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class UserMapper {

    public static User toUser(RegisterDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstName());
        user.setLastname(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setActive(true);
        return user;
    }


}

