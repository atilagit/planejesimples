package com.atimat.planejesimples.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atimat.planejesimples.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
