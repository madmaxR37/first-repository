package com.riderx.ecom.services.implementation;

import com.riderx.ecom.Repositories.RolesRepo;
import com.riderx.ecom.dto.RolesDto;
import com.riderx.ecom.exceptions.ErrorCodes;
import com.riderx.ecom.exceptions.InvalideEntityException;
import com.riderx.ecom.services.RolesService;
import com.riderx.ecom.validators.RolesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {

    private RolesRepo rolesRepo;

    @Autowired
    public RolesServiceImpl(RolesRepo rolesRepo){this.rolesRepo=rolesRepo;}

    @Override
    public RolesDto save(RolesDto rolesDto) {

        List<String> errors = RolesValidator.validate(rolesDto);
        if(!errors.isEmpty()){
            log.error("Invalid role");
            throw new InvalideEntityException("The item is not valid ", ErrorCodes.ROLE_NOT_VALID, errors);
        }
        return RolesDto.fromEntity(rolesRepo.save(RolesDto.toEntity(rolesDto)));
    }

    @Override
    public void deleteById(Long id) {

        if(id == null){
            log.error("This id is null");
        }

        rolesRepo.deleteById(id);
    }
}
