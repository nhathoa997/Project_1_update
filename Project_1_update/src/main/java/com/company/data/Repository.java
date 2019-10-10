package com.company.data;

import com.company.models.reimbursement;

import java.util.Collection;

public interface Repository<ID, E> {
    Collection<E> findAll();
    void save(E obj);
    void delete(String obj);
}
