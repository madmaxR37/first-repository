package com.riderx.ecom.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address {

        @Column(name = "address1")
        private String address1;

        @Column(name = "address2")
        private String address2;

        @Column(name = "city")
        private String city;

        @Column(name = "postal_code")
        private String postalCode;

        @Column(name = "country")
        private String country;
    }


