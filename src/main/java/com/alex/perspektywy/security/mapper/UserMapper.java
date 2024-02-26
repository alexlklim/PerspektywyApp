package com.alex.perspektywy.security.mapper;

import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.domain.dto.UserDto;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        dto.setId(user.getId());
        dto.setCreatedAt(user.getCreated());
        dto.setUpdatedAt(user.getUpdated());
        dto.setRole(List.of(user.getRoles().name()));
        return dto;
    }





}

