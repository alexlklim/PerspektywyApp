package com.alex.perspektywy.users.services;

import com.alex.perspektywy.users.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface IUserService {


    UserDTO getUserById(Long userId);

    List<UserDTO> getByUserStatus(String status);

    void updateUser(Long userId, Map<String, Object> updates);
}
