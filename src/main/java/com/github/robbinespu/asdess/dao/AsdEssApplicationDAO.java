package com.github.robbinespu.asdess.dao;

import com.github.robbinespu.model.Store;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsdEssApplicationDAO extends Repository{
    Store findByName(String name);

    void save(Store store);

    void delete(Store byName);

    List<Store> findAll();
}
