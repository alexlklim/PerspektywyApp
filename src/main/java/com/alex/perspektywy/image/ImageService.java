package com.alex.perspektywy.image;


import com.alex.perspektywy.image.domain.Image;
import com.alex.perspektywy.image.domain.ImageRepo;
import com.alex.perspektywy.users.repo.UserRepo;
import com.alex.perspektywy.utils.exceptions.errors.ImageException;
import com.alex.perspektywy.utils.exceptions.errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService implements IImageInterface{

    private final String TAG = "IMAGE_SERVICE - ";

    private final ImageRepo imageRepo;
    private final UserRepo userRepo;


    @Override
    @SneakyThrows
    public Long uploadImage(MultipartFile file, Long userId) throws IOException {
        log.info(TAG + "Get latest news DESC");
        Image image = imageRepo.save(Image.builder()
                .title(file.getOriginalFilename())
                .type(file.getContentType())
                .user(userRepo.getUser(userId))
                .imageData(ImageUtil.compressImage(file.getBytes())).build());
        return image.getId();

    }
    @Override
    @SneakyThrows
    public Image getInfoById(Long imageId) {
        log.info(TAG + "Get info image by id");
        Image dbImage = getImage(imageId);
        dbImage.setImageData(ImageUtil.decompressImage(dbImage.getImageData()));
        return dbImage;

    }

    @Override
    @SneakyThrows
    public byte[] getImageById(Long imageId) {
        log.info(TAG + "Get image by id");
        return ImageUtil.decompressImage(getImage(imageId).getImageData());
    }


    @SneakyThrows
    private Image getImage(Long imageId){
        log.info(TAG + "Get image by  from DB");
        return imageRepo.findById(imageId).orElseThrow(
                () -> new ResourceNotFoundException("Image not found with id " + imageId)
        );
    }
}
