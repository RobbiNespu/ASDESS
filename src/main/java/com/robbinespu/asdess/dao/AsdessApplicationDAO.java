package com.robbinespu.asdess.dao;

import com.robbinespu.asdess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsdessApplicationDAO extends JpaRepository<User, Integer> {
    User findByName(String name);
}
