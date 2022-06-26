package com.epam.conferences.repository.dao;

import com.epam.conferences.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface Readable<T extends Entity<ID>, ID> {
    /**
     * Finds POJO from database by id.
     * @param id primary key of POJO
     * @return Optional with object if found, otherwise an empty Optional
     * @since 1.0
     * @see Optional
     * */
    Optional<T> findById(ID id);

    /**
     * Finds all POJO from database.
     * @return List of POJO
     * @since 1.0
     * @see List
     * */
    List<T> findAll();
}
