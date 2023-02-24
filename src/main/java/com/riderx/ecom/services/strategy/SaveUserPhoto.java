package com.riderx.ecom.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.riderx.ecom.dto.UserDto;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.services.ImageService;
import com.riderx.ecom.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("userStrategy")
@Slf4j
public class SaveUserPhoto implements Strategy<UserDto> {

    private ImageService imageService;
    private UserService userService;

    @Autowired
    public SaveUserPhoto(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @Override
    public UserDto savePhoto(Long id, InputStream image, String title) throws FlickrException {

        UserDto user = userService.findById(id);
        String url = imageService.saveImage(image, title);
        if(!StringUtils.hasLength(url)){
            throw new InvalideEntityException("Image saving item error", ErrorCodes.UPDATE_IMAGE_EXCEPTION);
        }
        user.setProfile(url);
        return userService.save(user);
    }
}
