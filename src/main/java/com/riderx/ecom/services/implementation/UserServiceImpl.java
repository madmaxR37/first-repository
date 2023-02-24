package com.riderx.ecom.services.implementation;

import com.riderx.ecom.Repositories.UserRepo;
import com.riderx.ecom.dto.UserDto;
import com.riderx.ecom.exceptions.EntityNotFoundException;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.models.User;
import com.riderx.ecom.services.UserService;
import com.riderx.ecom.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto save(UserDto userDto) {
        List<String> errors = UserValidator.validate(userDto);
        if(!errors.isEmpty()){
            log.error("user is not valid {} ", userDto);
            throw new InvalideEntityException("The item is not valid ", ErrorCodes.USER_NOT_VALID);
        }
        return userDto.fromEntity(userRepo.save(userDto.toEntity(userDto)));
    }

    @Override
    public UserDto findById(Long id) {
        if(id == null){
            log.error("id is null");
            return null;
        }

        Optional<User> user = userRepo.findById(id);
        UserDto userDto = UserDto.fromEntity(user.get());
        return Optional.of(userDto).orElseThrow(()->
                new EntityNotFoundException("No user with id " +id, ErrorCodes.USER_NOT_FOUND)
                );
    }

    @Override
    public UserDto findByEmailAddress(String email) {
        return userRepo.findByEmailAddress(email)
                .map(UserDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "No user with email " + "in the database",
                        ErrorCodes.USER_NOT_FOUND
                ));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepo.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Null id");
        }

        userRepo.deleteById(id);

    }
}
