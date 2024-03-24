package com.alex.perspektywy.users.services;

import com.alex.perspektywy.security.dto.UserDto;

import java.util.List;

public interface IUserService {


    UserDto updateUser(UserDto userDto);

    void addSpeakingLang(List<String> speakingLangs);
}
