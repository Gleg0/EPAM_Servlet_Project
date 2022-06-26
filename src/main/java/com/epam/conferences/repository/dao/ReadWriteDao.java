package com.epam.conferences.repository.dao;

import com.epam.conferences.entity.Entity;

public interface ReadWriteDao<T extends Entity<ID>, ID> extends Insertable<T,ID>,Readable<T,ID>{
}
