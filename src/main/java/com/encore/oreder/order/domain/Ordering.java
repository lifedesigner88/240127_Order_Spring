package com.encore.oreder.order.domain;

import com.encore.oreder.member.domain.Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

//    Time
    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;
}


