package com.riderx.ecom.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Embedded
    @Column(name = "address")
    private Address address;

    @Column(name = "email_address", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "user_roles")
    private Roles roles;

    @CreatedDate
    @Column(name = "creation_date")
    private Instant creationDate;

    @Column(name = "kyc")
    private String kyc;

    @Column(name = "profile")
    private String profile;

    @OneToMany(mappedBy = "user")
    private List<Item> items;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
