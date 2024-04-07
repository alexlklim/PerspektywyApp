package com.alex.perspektywy.notification;


import com.alex.perspektywy.notification.domain.NotificationDto;
import com.alex.perspektywy.utils.SecHolder;
import com.alex.perspektywy.utils.dto.DtoActiveBool;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
@Tag(name = "Notification Controller", description = "Notification API")
public class NotificationController {

    private final String TAG = "NOTIFICATION_CONTROLLER - ";

    private final NotificationService notificationService;


    @Operation(summary = "Get all notification for authorized user")
    @GetMapping
    public ResponseEntity<List<NotificationDto>> getNotifications() {
        log.info(TAG + "Get all notifications");
        return new ResponseEntity<>(
                notificationService.getNotifications(SecHolder.getUserId()),
                HttpStatus.OK);
    }


    @Operation(summary = "Read all notification")
    @GetMapping("/read")
    public ResponseEntity<HttpStatus> readAllNotifications() {
        log.info(TAG + "Read all notifications");
        notificationService.readAllNotifications(SecHolder.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Read notification by id")
    @PutMapping("/read/{id}")
    public ResponseEntity<HttpStatus> readNotificationById(
            @PathVariable("id") Long notificationId) {
        log.info(TAG + "Read notification with id {}", notificationId);
        notificationService.readNotification(
                SecHolder.getUserId(),
                notificationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Send notification to specific user")
    @Secured("ROLE_ADMIN")
    @PostMapping("/notify/{id}")
    public ResponseEntity<HttpStatus> sendNotificationToSpecificUser(
            @PathVariable("id") Long userToId,
            @RequestBody NotificationDto notificationDto) {
        log.info(TAG + "Send notification to user with id {}", userToId);
        notificationService.saveNotificationToSpecificUser(
                notificationDto,
                userToId,
                SecHolder.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Send notification to all users")
    @Secured("ROLE_ADMIN")
    @PostMapping("/notify")
    public ResponseEntity<HttpStatus> sendNotificationToAllUsers(
            @RequestBody NotificationDto notificationDto) {
        log.info(TAG + "Send notification to all users");
        notificationService.saveNotificationToAllUsers(
                notificationDto,
                SecHolder.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Change visibility of notification")
    @Secured("ROLE_ADMIN")
    @PutMapping("/active")
    public ResponseEntity<HttpStatus> changeVisibilityOfNotification(
            @RequestBody DtoActiveBool activeDto) {
        log.info(TAG + "Change visibility of notification with id {} to status {}",
                activeDto.getId(), activeDto.isActive());
        notificationService.changeNotificationVisibility(
                activeDto,
                SecHolder.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
