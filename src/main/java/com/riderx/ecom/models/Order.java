package com.riderx.ecom.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long OrderId;

    @CreatedDate
    @Column(name = "date")
    private Instant orderDate;

    @OneToOne
    private Item item;

    @ManyToOne
    @JoinColumn(name = "users_orders")
    private User user;
}
