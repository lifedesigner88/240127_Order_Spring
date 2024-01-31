package com.encore.oreder.order.domain;

import com.encore.oreder.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.ORDERED;

//    Relation
    @ManyToOne
    @JoinColumn
    private Member member;

    @OneToMany (mappedBy = "ordering", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    public void addOrderItem (OrderItem item){
        orderItems.add(item);
    }


//    Mathod

    public Map<String, Integer> getItemNameAndQuantity () {
        Map<String, Integer> itemNameAndQuantity = new HashMap<>();
        for (OrderItem orderItem : orderItems)
            itemNameAndQuantity.put(
                    orderItem.getItem().getName(),
                    orderItem.getQuantity());
        return itemNameAndQuantity;
    }



//    Time
    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;
}


