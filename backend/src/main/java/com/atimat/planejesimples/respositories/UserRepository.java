package com.atimat.planejesimples.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atimat.planejesimples.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
