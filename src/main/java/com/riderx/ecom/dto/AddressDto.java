package com.riderx.ecom.dto;


import com.riderx.ecom.models.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String address1;

    private String address2;

    private String city;

    private String postalCode;

    private String country;


    public AddressDto fromEntity(Address address){

        if(address == null){
            return null;
            //TODO throw exception
        }

        return AddressDto.builder().address1(address.getAddress1())
                .address2(address.getAddress2())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .build();
    }

    public Address toEntity(AddressDto addressDto){

        if(addressDto == null){
            return null;
            //TODO throw exception
        }

        return Address.builder().address1(addressDto.getAddress1())
                .address2(addressDto.getAddress2())
                .city(addressDto.getCity())
                .postalCode(addressDto.getPostalCode())
                .country(addressDto.getCountry())
                .build();
    }



}
