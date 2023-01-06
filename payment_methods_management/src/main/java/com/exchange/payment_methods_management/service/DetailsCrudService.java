package com.exchange.payment_methods_management.service;

public interface DetailsCrudService<T, I> {

    void add(T T);

    void update(T T, I id);

    void delete(I id, String email);

    T get(I id, String email);

}
