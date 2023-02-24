package com.riderx.ecom.services.strategy;


import com.flickr4java.flickr.FlickrException;
import com.riderx.ecom.dto.ItemDto;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.services.ImageService;
import com.riderx.ecom.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
@Service("itemStrategy")
@Slf4j
public class SaveItemImage implements Strategy<ItemDto> {

    private ImageService imageService;
    private ItemService itemService;

    @Autowired
    public SaveItemImage(ImageService imageService, ItemService itemService) {
        this.imageService = imageService;
        this.itemService = itemService;
    }

    @Override
    public ItemDto savePhoto(Long id, InputStream image, String title) throws FlickrException {

        ItemDto item = itemService.findByID(id);
        String url = imageService.saveImage(image, title);
        if(!StringUtils.hasLength(url)){
            throw new InvalideEntityException("Image saving item error", ErrorCodes.UPDATE_IMAGE_EXCEPTION);
        }

        item.setImage(url);
        return itemService.save(item);
    }
}
