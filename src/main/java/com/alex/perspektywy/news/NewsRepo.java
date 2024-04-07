package com.alex.perspektywy.news;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepo extends JpaRepository<News, Long> {


    @Query("SELECT n " +
            "FROM News n " +
            "ORDER BY n.created DESC")
    List<News> getLatest();
}
