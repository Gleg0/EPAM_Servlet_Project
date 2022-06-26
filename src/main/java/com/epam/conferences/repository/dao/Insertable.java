package com.epam.conferences.repository.dao;

import com.epam.conferences.entity.Entity;

import java.util.Objects;

public interface Insertable<T extends Entity<ID>, ID>{

    /**
     * Saves POJO in database.
     * Depending on presence object in databases, execute creating or updating operations. <br>
     * If objects doesn't belong to the database, insert it into. <br>
     * If objects has specified id and belongs to the database, makes update.
     * @param o POJO to save
     * @return saved POJO
     * @since 1.0
     * */
    default T save(T o){
        if (Objects.isNull(o.getId())){
            return insert(o);
        }
        else {
            return update(o);
        }
    }

    /**
     * Updates POJO in database.
     * @param o POJO to update
     * @return updated POJO
     * @since 1.1
     * */
    T insert(T o);

    /**
     * Inserts POJO to database.
     * @param o POJO to insert
     * @return inserted POJO
     * @since 1.1
     * */
    T update(T o);
}
