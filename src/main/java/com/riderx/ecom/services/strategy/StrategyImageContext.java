package com.riderx.ecom.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StrategyImageContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    @Autowired
    public StrategyImageContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object saveImage(String context, Long id, InputStream image, String title) throws FlickrException{
        determinationContext(context);
        return strategy.savePhoto(id, image, title);
    }

        private void  determinationContext(String context){

        final String beanName = context + "Strategy";
        switch (context){
            case "item":
                strategy = beanFactory.getBean(beanName, SaveItemImage.class);
                break;
            case "user":
                strategy = beanFactory.getBean(beanName, SaveUserPhoto.class);
                break;
            case "kyc":
                strategy = beanFactory.getBean(beanName, SaveUserKyc.class);
                break;
                default: throw  new InvalideEntityException("unknown context for saving", ErrorCodes.UNKNOWN_CONTEXT);
        }
        }
}
