package com.marcos.store.controllers;

import com.marcos.store.models.Order;
import com.marcos.store.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findOrder() {
        List<Order> Orders = service.findAll();

        return ResponseEntity.ok().body(Orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(
            @PathVariable
            Long id
    ) {
        Order Order = service.findById(id);

        return ResponseEntity.ok().body(Order);
    }
}
