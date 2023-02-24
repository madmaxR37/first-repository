package com.riderx.ecom.services.implementation;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.riderx.ecom.services.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Value("${flickr.apiKey}")
    private String apiKey;

    @Value("${flickr.apiSecret}")
    private String apiSecret;

    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

    private Flickr flickr;

    @Override
    public String saveImage(InputStream image, String title) throws FlickrException {

        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(title);

        String photoiId = flickr.getUploader().upload(image, uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoiId).getMedium640Url();
    }

    public void connect(){

        flickr = new Flickr(apiKey, apiSecret, new REST());

        Auth auth = new Auth();

        auth.setPermission(Permission.DELETE);

        auth.setToken(apiKey);
        auth.setTokenSecret(appSecret);

        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);

        flickr.setAuth(auth);
    }
}
