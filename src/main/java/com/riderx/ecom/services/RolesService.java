package com.riderx.ecom.services;

import com.riderx.ecom.dto.RolesDto;

public interface RolesService {

    RolesDto save(RolesDto rolesDto);

    void deleteById(Long id);
}
