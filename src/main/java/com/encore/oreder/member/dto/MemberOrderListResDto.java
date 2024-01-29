package com.encore.oreder.member.dto;

import com.encore.oreder.order.domain.OrderItem;
import com.encore.oreder.order.domain.Ordering;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Getter
public class MemberOrderListResDto {

    private final Integer orderId;
    private final String orderStatus;
    private final Map<String, Integer> ItemNameAndQuantity;

    public MemberOrderListResDto (Ordering order){
        this.orderId = order.getId();
        this.orderStatus = order.getOrderStatus().toString();

        this.ItemNameAndQuantity = new HashMap<>();
        for (OrderItem orderItem : order.getOrderItems())
            this.ItemNameAndQuantity.put(
                    orderItem.getItem().getName(),
                    orderItem.getQuantity());
    }
}
