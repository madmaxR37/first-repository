package com.riderx.ecom.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface ImageService {

    String saveImage(InputStream image, String title) throws FlickrException;
}
