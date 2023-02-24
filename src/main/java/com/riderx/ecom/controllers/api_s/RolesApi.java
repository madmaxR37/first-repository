package com.riderx.ecom.controllers.api_s;

import com.riderx.ecom.dto.RolesDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.riderx.ecom.utils.Constant.APP_ROOT;

@Api(APP_ROOT + "/Roles")
public interface RolesApi {
    @PostMapping(value = APP_ROOT + "/roles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Save a role", notes = "This method saves/modifies a role", response = RolesDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "role created/modified"),
            @ApiResponse(code = 400, message = "role is not valid")
    })
    RolesDto save(@RequestBody RolesDto itemDto);

    @DeleteMapping(value = APP_ROOT + "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value ="Deletes a role", notes = "This method Delete an role ", response = RolesDto.class)
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "role deleted"),
    })
    void delete(@PathVariable Long id);
}
