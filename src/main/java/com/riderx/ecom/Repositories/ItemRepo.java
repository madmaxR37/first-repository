package com.riderx.ecom.Repositories;

import com.riderx.ecom.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item,Long> {

    List<Item> findByItemNameStartingWith(String name);
}
