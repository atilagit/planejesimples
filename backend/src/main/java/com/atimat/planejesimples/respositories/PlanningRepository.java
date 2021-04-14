package com.atimat.planejesimples.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atimat.planejesimples.entities.Planning;

@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long>{

}
