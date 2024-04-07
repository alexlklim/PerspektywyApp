package com.alex.perspektywy.image;

import com.alex.perspektywy.image.domain.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageInterface {


    Long uploadImage(MultipartFile file, Long userId) throws IOException;
    Image getInfoById(Long imageId);
    byte[] getImageById(Long imageId);
}
