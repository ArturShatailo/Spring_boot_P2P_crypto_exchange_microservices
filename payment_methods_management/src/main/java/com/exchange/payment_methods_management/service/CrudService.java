package com.exchange.payment_methods_management.service;

import java.util.List;

public interface CrudService<T, I> {

    T create(T T);

    void update(T T, I id);

    void delete(I id);

    List<T> getAll();

    T get(I id);


}
