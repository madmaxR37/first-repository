package com.riderx.ecom.controllers;

import com.riderx.ecom.controllers.api_s.RolesApi;
import com.riderx.ecom.dto.RolesDto;
import com.riderx.ecom.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesController implements RolesApi {

    private RolesService rolesService;

    @Autowired
    public RolesController( RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Override
    public RolesDto save(RolesDto itemDto) {
        return rolesService.save(RolesDto.builder().build());
    }

    @Override
    public void delete(Long id) {

        rolesService.deleteById(id);
    }
}
