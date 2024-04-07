package com.alex.perspektywy.image;


import com.alex.perspektywy.image.domain.Image;
import com.alex.perspektywy.utils.SecHolder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/image")
@Tag(name = "Image Controller", description = "Image API")
public class ImageController {
    private final String TAG = "NEWS_CONTROLLER - ";

    private final IImageInterface imageService;


    @Operation(summary = "Upload image by id")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public Long uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        log.info(TAG + "Upload image by id");
        return imageService.uploadImage(file, SecHolder.getUserId());

    }

    @Operation(summary = "Get info about image by id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/info/{image_id}")
    public Image getImageInfoById(@PathVariable("image_id") Long imageId) {
        log.info(TAG + "Upload image by id");
        return imageService.getInfoById(imageId);
    }

    @Operation(summary = "Get image by id")
    @GetMapping("/{image_id}")
    public ResponseEntity<?> getImageByName(@PathVariable("image_id") Long imageId) {
        log.info(TAG + "Get image by id");
        byte[] image = imageService.getImageById(imageId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

}
