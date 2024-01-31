package com.encore.oreder.order.dto;

import com.encore.oreder.member.domain.Member;
import com.encore.oreder.order.domain.Ordering;
import lombok.Getter;

import java.util.Map;

@Getter
public class OrderWithMemberResDto {

    private final Integer memberId;
    private final String name;

    private final Integer orderId;
    private final Map<String, Integer> itemNameAndQuantity;

    public OrderWithMemberResDto(Ordering order){
        Member member = order.getMember();
        this.memberId = member.getId();
        this.name = member.getName();
        this.orderId = order.getId();
        this.itemNameAndQuantity = order.getItemNameAndQuantity();
    }

}
