package com.riderx.ecom.controllers.api_s;

import com.flickr4java.flickr.FlickrException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/Image")
public interface ImageApi {

    @PostMapping(value = APP_ROOT + "/image/{id}/{title}/{context}")
    Object saveImage(String context, Long id, @RequestPart("file") MultipartFile image, String title) throws IOException, FlickrException;
}
