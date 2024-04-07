package com.alex.perspektywy.news;


import com.alex.perspektywy.users.domain.User;
import com.alex.perspektywy.users.repo.UserRepo;
import com.alex.perspektywy.utils.exceptions.errors.ResourceNotFoundException;
import com.alex.perspektywy.utils.exceptions.errors.user_error.UserIsNotOwner;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsService implements INewsInterface{

    private final String TAG = "NEWS_SERVICE - ";

    private final NewsRepo newsRepo;
    private final UserRepo userRepo;

    @Override
    @SneakyThrows
    public NewsDTO getNewsById(Long newsId) {
        log.info(TAG + "Get news by id");
        return getDtoFromNews(newsRepo.findById(newsId).orElseThrow(
                () -> new ResourceNotFoundException("New not found with id " + newsId)
        ));
    }


    @Override
    public List<NewsDTO> getLatestNews() {
        log.info(TAG + "Get latest news DESC");
        return newsRepo.getLatest()
                .stream()
                .map(this::getDtoFromNews)
                .collect(Collectors.toList());

    }


    @Override
    public void createNews(NewsDTO newsDTO, Long userId) {
        log.info(TAG + "Create news");
        News news = new News().toBuilder()
                .title(newsDTO.getTitle())
                .description(newsDTO.getDescription())
                .imageId(newsDTO.getImageId())
                .user(getUser(userId))
                .build();
        newsRepo.save(news);
    }

    @Override
    public void updateNews(Map<String, Object> updates, Long userId) {
        log.info(TAG + "Update news");
        News news = newsRepo.findById(((Number) updates.getOrDefault("id", null)).longValue()).orElseThrow(
                () -> new ResourceNotFoundException("News not found")
        );
        if (!news.getUser().equals(getUser(userId)))
            throw new UserIsNotOwner("User is not owner of news with id " + news.getId());
        updates.forEach((key, value) -> {
            switch (key) {
                case "title":
                    news.setTitle((String) value);
                case "description":
                    news.setDescription((String) value);
                case "image_id":
                    news.setImageId(((Number) value).longValue());
                case "is_active":
                    news.setActive((Boolean) value);
            }
        });

    }

    @SneakyThrows
    private User getUser(Long userId) {
        log.info(TAG + "Get user");
        return userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id " + userId)
        );
    }


    private NewsDTO getDtoFromNews(News news){
        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setDescription(news.getDescription());
        dto.setAuthorId(news.getUser().getId());
        dto.setAuthor(news.getUser().getFirstname()+ " " + news.getUser().getLastname());
        dto.setImageId(news.getImageId());
        return dto;

    }
}
