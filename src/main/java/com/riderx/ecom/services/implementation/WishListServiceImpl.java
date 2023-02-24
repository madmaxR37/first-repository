package com.riderx.ecom.services.implementation;

import com.riderx.ecom.Repositories.WishListRepo;
import com.riderx.ecom.dto.WishListDto;
import com.riderx.ecom.exceptions.EntityNotFoundException;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.models.WishList;
import com.riderx.ecom.services.WishListService;
import com.riderx.ecom.validators.WishListValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WishListServiceImpl implements WishListService {

    private WishListRepo wishListRepo;

    @Autowired
    public WishListServiceImpl(WishListRepo wishListRepo){
        this.wishListRepo = wishListRepo;
    }

    @Override
    public WishListDto save(WishListDto wishListDto) {

        List<String> errors = WishListValidator.validate(wishListDto);
        if(!errors.isEmpty()){
            log.error("the wishList {} is not valid", wishListDto);
            throw new InvalideEntityException("The wishList is not valid", ErrorCodes.CART_NOT_VALID, errors);
        }

        return WishListDto.fromEntity(wishListRepo.save(WishListDto.toEntity(wishListDto)));
    }

    @Override
    public WishListDto findByID(Long id) {

        if(id == null){
            log.error("null id");
            return null;
        }
        Optional<WishList> cart = wishListRepo.findById(id);
        WishListDto wishListDto = WishListDto.fromEntity(cart.get());
        return Optional.of(wishListDto).orElseThrow(()->
                new EntityNotFoundException("Entity with id "+id+" not found", ErrorCodes.CART_NOT_FOUND)
        );
    }


    @Override
    public List<WishListDto> findAll() {

        return wishListRepo.findAll().stream()
                .map(WishListDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if(id == null){

            log.error("Null ID ");
        }

        wishListRepo.deleteById(id);
    }

}
