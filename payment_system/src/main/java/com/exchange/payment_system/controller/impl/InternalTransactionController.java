package com.exchange.payment_system.controller.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/ps/internal", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class InternalTransactionController {



}
