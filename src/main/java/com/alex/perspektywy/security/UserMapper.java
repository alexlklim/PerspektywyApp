package com.alex.perspektywy.security;

import com.alex.perspektywy.security.domain.Role;
import com.alex.perspektywy.security.domain.User;
import com.alex.perspektywy.security.dto.RegisterDto;
import com.alex.perspektywy.security.dto.UserDto;
import com.alex.perspektywy.utils.DateService;
import lombok.Data;

@Data
public class UserMapper {

    public static User toUser(RegisterDto dto) {
        User user = new User();
        user.setFirstname(dto.getFirstName());
        user.setLastname(dto.getLastName());
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        user.setRoles(Role.fromString(dto.getRole()));
        user.setActive(true);
        user.setLastActivity(DateService.getDateNow());
        return user;
    }


    public static UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstname());
        dto.setLastName(entity.getLastname());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setActive(entity.isActive());
        dto.setRole(entity.getRoles().name());
        dto.setLastActivity(DateService.getDateNow());
        dto.setLastActivity(entity.getLastActivity());
        return dto;
    }


}
