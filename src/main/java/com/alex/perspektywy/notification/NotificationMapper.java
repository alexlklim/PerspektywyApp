package com.alex.perspektywy.notification;


import com.alex.perspektywy.notification.domain.Notification;
import com.alex.perspektywy.notification.domain.NotificationDto;
import com.alex.perspektywy.notification.domain.Reason;
import com.alex.perspektywy.users.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationMapper {


    public NotificationDto mapToDto(Notification notification){
        NotificationDto dto = new NotificationDto();
        dto.setCreated(notification.getCreated());
        dto.setRead(notification.isViewed());
        dto.setReason(notification.getReason().name());
        dto.setMessage(notification.getMessage());
        dto.setFromWho(notification.getCreatedBy() != null ?
                notification.getCreatedBy().getFirstname() + " " + notification.getCreatedBy().getLastname() : "Inwento");
        return dto;
    }




    public Notification mapToEntity(NotificationDto dto, User userTo, User userFrom){
        Notification notification = new Notification();
        notification.setActive(true);
        notification.setViewed(false);
        notification.setReason(Reason.fromString(dto.getReason()));
        notification.setMessage(dto.getMessage());
        notification.setCreatedBy(userFrom);
        notification.setUser(userTo);
        return notification;
    }



}
