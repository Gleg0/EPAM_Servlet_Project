package com.epam.conferences.repository.dao;

import com.epam.conferences.entity.Entity;

/**
 * Common generic CRUD interface for all DAO repositories.
 * @version 1.1
 * */
public interface Dao<T extends Entity<ID>, ID> extends Readable<T,ID>, Insertable<T,ID>, Removable<T,ID> {

}
