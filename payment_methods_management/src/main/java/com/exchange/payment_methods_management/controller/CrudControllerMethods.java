package com.exchange.payment_methods_management.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface CrudControllerMethods<D, T, I>{

    @PostMapping(value = "/")
    T create(@RequestBody D dto);

    @PutMapping(value = "/{id}")
    void update(@RequestBody D dto, @PathVariable I id);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable I id);

    @GetMapping(value = "/")
    List<T> getAll();

    @GetMapping(value = "/{id}")
    T get(@PathVariable I id);

}
