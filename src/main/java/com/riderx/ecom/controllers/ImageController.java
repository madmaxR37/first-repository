package com.riderx.ecom.controllers;

import com.flickr4java.flickr.FlickrException;
import com.riderx.ecom.controllers.api_s.ImageApi;
import com.riderx.ecom.services.strategy.StrategyImageContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageController implements ImageApi {

    private StrategyImageContext strategyImageContext;

    @Autowired
    public ImageController(StrategyImageContext strategyImageContext) {
        this.strategyImageContext = strategyImageContext;
    }

    @Override
    public Object saveImage(String context, Long id, MultipartFile image, String title) throws IOException, FlickrException {
        return strategyImageContext.saveImage(context, id, image.getInputStream(),title);
    }
}
