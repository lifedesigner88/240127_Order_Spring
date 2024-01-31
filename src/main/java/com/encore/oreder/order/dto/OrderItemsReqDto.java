package com.encore.oreder.order.dto;

import com.encore.oreder.order.domain.OrderItem;
import com.encore.oreder.order.domain.Ordering;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
public class OrderItemsReqDto {

    private Integer memberId;
    private List<OrderItemDto> orderItems;

    @Setter
    @Getter
    public static class OrderItemDto {
        private Integer itemId;
        private int count;
    }
}


