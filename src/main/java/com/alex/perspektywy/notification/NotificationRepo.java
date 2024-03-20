package com.alex.perspektywy.notification;

import com.alex.perspektywy.notification.domain.Notification;
import com.alex.perspektywy.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NotificationRepo extends JpaRepository<Notification, Long> {



    Optional<Notification> getNotificationByIdAndUser(Long id, User user);

    @Query("SELECT n " +
            "FROM Notification n " +
            "WHERE n.isActive = true AND n.user = ?1 " +
            "ORDER BY n.created DESC")
    List<Notification> getNotificationsByUser(User user);

    @Query("SELECT n " +
            "FROM Notification n " +
            "WHERE n.isActive = true AND n.isViewed = false AND n.user = ?1 " +
            "ORDER BY n.created DESC")
    List<Notification> getNotViewedNotifications(User user);


}
