package com.encore.oreder.member.dto;

import com.encore.oreder.order.domain.Ordering;
import lombok.Getter;

import java.util.Map;


@Getter
public class MemberOrderResDto {

    private final Integer orderId;
    private final String orderStatus;
    private final Map<String, Integer> itemNameAndQuantity;

    public MemberOrderResDto(Ordering order){
        this.orderId = order.getId();
        this.orderStatus = order.getOrderStatus().toString();
        this.itemNameAndQuantity = order.getItemNameAndQuantity();
    }
}
