package com.encore.oreder.order.controller;

import com.encore.oreder.order.dto.OrderItemsReqDto;
import com.encore.oreder.order.dto.OrderWithMemberResDto;
import com.encore.oreder.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService service;
    public OrderController(@Autowired OrderService service) {
        this.service = service;
    }

    @GetMapping("list")
    public List<OrderWithMemberResDto> getOrderListWithName(){
        return service.getOrderListWithName();
    }

    @PostMapping("new")
    public OrderWithMemberResDto orderItems (@RequestBody OrderItemsReqDto dto){
        return service.orderItems(dto);
    }



}
