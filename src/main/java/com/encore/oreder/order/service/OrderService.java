package com.encore.oreder.order.service;

import com.encore.oreder.member.dto.MemberResDto;
import com.encore.oreder.order.domain.OrderItem;
import com.encore.oreder.order.domain.Ordering;
import com.encore.oreder.order.dto.OrderItemsReqDto;
import com.encore.oreder.order.dto.OrderWithMemberResDto;
import com.encore.oreder.order.repository.ItemRepository;
import com.encore.oreder.order.repository.OrderItemRepository;
import com.encore.oreder.order.repository.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderingRepository orderRepo;
    private final OrderItemRepository orderItemReop;
    private final ItemRepository itemRepo;

    @Autowired
    public OrderService(OrderingRepository orderRepo,
                        OrderItemRepository orderItemReop,
                        ItemRepository itemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemReop = orderItemReop;
        this.itemRepo = itemRepo;
    }

    public List<OrderWithMemberResDto> getOrderListWithName() {
        return orderRepo.findAll().stream()
                .map(OrderWithMemberResDto::new)
                .collect(Collectors.toList());
    }


    public OrderWithMemberResDto orderItems(OrderItemsReqDto dto) {


        for (OrderItemsReqDto.OrderItemDto itemDto : dto.getOrderItems()) {
            OrderItem item = new OrderItem();
        }

        Ordering order = new Ordering();

        Ordering savedOrder = orderRepo.save(order);
        return new OrderWithMemberResDto(savedOrder);
    }
}
