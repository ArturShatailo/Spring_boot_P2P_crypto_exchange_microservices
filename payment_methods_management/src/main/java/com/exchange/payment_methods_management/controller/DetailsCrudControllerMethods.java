package com.exchange.payment_methods_management.controller;

import org.springframework.web.bind.annotation.*;

public interface DetailsCrudControllerMethods<D, T, I> {

    @PostMapping(value = "/")
    void addDetails(@RequestBody D dto);

    @PutMapping(value = "/", params = {"id"})
    void updateDetails(@RequestBody D dto, @RequestParam I id);

    @DeleteMapping(value = "/" , params = {"id", "email"})
    void deleteDetails(@RequestParam I id, @RequestParam String email);

    @GetMapping(value = "/", params = {"id", "email"})
    T getDetails(@PathVariable I id, @RequestParam String email);

}
