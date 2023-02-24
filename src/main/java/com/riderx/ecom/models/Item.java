package com.riderx.ecom.models;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "image")
    private String image;

    @Column(name = "unit_price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "item_list")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "wishList")
    private WishList wishList;

    @OneToOne
    private Order order;

    @ManyToOne
    @JoinColumn(name = "users_items")
    private User user;
}
