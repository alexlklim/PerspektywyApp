package com.alex.perspektywy.news;

import java.util.List;
import java.util.Map;

public interface INewsInterface {

    NewsDTO getNewsById(Long newsId);
    List<NewsDTO> getLatestNews();
    void createNews(NewsDTO newsDTO, Long userId);
    void updateNews(Map<String, Object> updates, Long userId);
}
