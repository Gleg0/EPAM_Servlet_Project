package com.epam.conferences.repository.dao;

import com.epam.conferences.entity.Entity;

public interface Removable <T extends Entity<ID>, ID>{
    /**
     * Removes POJO from database by id.<br>
     * @param o POJO to delete
     * */

    void delete(T o);
}
