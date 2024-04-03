package com.alex.perspektywy.users.services.imp;

import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.users.domain.Education;
import com.alex.perspektywy.users.domain.enums.Degree;
import com.alex.perspektywy.users.domain.enums.Specialization;
import com.alex.perspektywy.users.domain.enums.Universities;
import com.alex.perspektywy.users.dto.EducationDTO;
import com.alex.perspektywy.users.dto.EducationFieldsDTO;
import com.alex.perspektywy.users.repo.EducationRepo;
import com.alex.perspektywy.users.repo.UserRepo;
import com.alex.perspektywy.users.services.IEducationService;
import com.alex.perspektywy.utils.exceptions.errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EducationService implements IEducationService {
    private final String TAG = "EDUCATION_SERVICE - ";

    private final UserRepo userRepo;
    private final EducationRepo educationRepo;


    @Override
    public EducationFieldsDTO getEducationFields() {
        return new EducationFieldsDTO().toBuilder()
                .degree(Degree.getAll())
                .specializations(Specialization.getAll())
                .universities(Universities.getAll())
                .build();
    }


    @Override
    @SneakyThrows
    public void updateEducationsForUser(
            List<EducationDTO> educationDTOList,
            Long userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id " + userId)
        );

        for (EducationDTO educationDto : educationDTOList) {
            updateOrAddEducation(educationDto, user);
        }

    }


    @SneakyThrows
    private void updateOrAddEducation(EducationDTO educationDto, User user) {
        Education education = new Education();
        education.setActive(educationDto.isActive());
        education.setCurrent(educationDto.isCurrent());
        education.setStartDate(educationDto.getStartDate());
        education.setFinishDate(educationDto.getFinishDate());
        education.setDegree(Degree.fromString(educationDto.getDegree()));
        education.setUniversity(Universities.fromString(educationDto.getUniversity()));
        education.setSpecialization(Specialization.fromString(educationDto.getSpecialization()));
        education.setUser(user);

        if (educationDto.getId() != null) {
            education.setId(educationDto.getId());
        }
        educationRepo.save(education);
    }

}
