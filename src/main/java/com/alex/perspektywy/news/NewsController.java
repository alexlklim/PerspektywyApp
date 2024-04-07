package com.alex.perspektywy.news;


import com.alex.perspektywy.utils.SecHolder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
@Tag(name = "News Controller", description = "News API")
public class NewsController {
    private final String TAG = "NEWS_CONTROLLER - ";

    private final NewsService newsService;


    @Operation(summary = "Get latest news DESC")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDTO> getLatestNews() {
        log.info(TAG + "Get latest news DESC");
        return newsService.getLatestNews();
    }

    @Operation(summary = "Get news by id")
    @GetMapping("/{news_id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsDTO getNewsById(
            @PathVariable("news_id") Long newsId) {
        log.info(TAG + "Get news by id");
        return newsService.getNewsById(newsId);
    }




    @Operation(summary = "Create news")
    @Secured("ROLE_ADMIN")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateNews(
            @RequestBody NewsDTO newsDTO) {
        log.info(TAG + "Create news");
        newsService.createNews(newsDTO, SecHolder.getUserId());
    }


    @Operation(summary = "Update news by id")
    @Secured("ROLE_ADMIN")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateNews(
            @RequestBody Map<String, Object> updates) {
        log.info(TAG + "Update news");
        newsService.updateNews(updates, SecHolder.getUserId());
    }
}
