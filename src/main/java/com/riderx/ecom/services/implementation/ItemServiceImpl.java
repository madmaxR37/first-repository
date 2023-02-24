package com.riderx.ecom.services.implementation;

import com.riderx.ecom.Repositories.ItemRepo;
import com.riderx.ecom.Repositories.UserRepo;
import com.riderx.ecom.dto.ItemDto;
import com.riderx.ecom.exceptions.EntityNotFoundException;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.models.Item;
import com.riderx.ecom.models.User;
import com.riderx.ecom.services.ItemService;
import com.riderx.ecom.validators.ItemValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private ItemRepo itemRepo;
    private UserRepo userRepo;

    @Autowired
    public ItemServiceImpl(ItemRepo itemRepo,UserRepo userRepo) {
        this.itemRepo = itemRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ItemDto save(ItemDto itemDto) {
        List<String> errors = ItemValidator.validate(itemDto);
        if(!errors.isEmpty()){
            log.error("Item is not valid {} ", itemDto);
            throw new InvalideEntityException("The item is not valid ", ErrorCodes.ITEM_NOT_VALID, errors);
        }
        Optional<User> user = userRepo.findById(itemDto.getUserDto().getId());
        if(!user.isPresent()){
            log.warn("user with id {} was not found in the DB", itemDto.getUserDto().getId() );
            throw new EntityNotFoundException("No user with id " +itemDto.getUserDto().getId(), ErrorCodes.USER_NOT_FOUND);
        }
        return ItemDto.fromEntity(itemRepo.save(ItemDto.toEntity(itemDto)));
    }

    @Override
    public ItemDto findByID(Long id) {

        if(id == null){

            log.error("This id is null");
            return null;
        }

        Optional<Item> item = itemRepo.findById(id);
        ItemDto itemDto = ItemDto.fromEntity(item.get());

        return Optional.of(itemDto).orElseThrow(() ->
        new EntityNotFoundException(
                "No Entity with id "+ id + "not found",
                ErrorCodes.ITEM_NOT_FOUND)
        );
    }

    @Override
    public List<ItemDto> findByItemNameStartingWith(String name) {
        if(!StringUtils.hasLength(name)){

            log.error("This name is null");
            return null;
        }

      return itemRepo.findByItemNameStartingWith(name).stream()
                .map(ItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> findAll() {
        return itemRepo.findAll().stream()
                .map(ItemDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(id == null){
            log.error("This id is null");
        }

        itemRepo.deleteById(id);
    }
}
