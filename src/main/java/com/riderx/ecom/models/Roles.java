package com.riderx.ecom.models;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "roles")

public class Roles {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role_name")
    private String name;

    @OneToMany(mappedBy = "roles")
    private List<User> users;
}
