package com.encore.oreder.member.domain;

import com.encore.oreder.order.domain.Ordering;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String adress;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Member() {}

    @Builder
    public Member(String name, String email, String password, String adress, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.adress = adress;
        this.role = role;
    }

    //    Relation
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Ordering> orderings = new ArrayList<>();


    public void addOrdering(Ordering ordering) {
        orderings.add(ordering);
    }

//    Time
    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;
}
