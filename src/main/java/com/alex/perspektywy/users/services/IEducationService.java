package com.alex.perspektywy.users.services;

import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.enums.Degree;
import com.alex.perspektywy.users.domain.enums.Specialization;
import com.alex.perspektywy.users.domain.enums.Universities;

import java.util.List;

public interface IEducationService {


    List<Degree> getDegrees();
    List<Specialization> getSpecializations();
    List<Universities> getUniversities();


    List<Education> getEducationsByUser(Long userId);
}
