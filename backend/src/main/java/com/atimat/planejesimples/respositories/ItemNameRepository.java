package com.atimat.planejesimples.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atimat.planejesimples.entities.ItemName;

@Repository
public interface ItemNameRepository extends JpaRepository<ItemName, Long>{

}
