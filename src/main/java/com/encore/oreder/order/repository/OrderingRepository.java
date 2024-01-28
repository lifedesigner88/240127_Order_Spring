package com.encore.oreder.order.repository;

import com.encore.oreder.order.domain.Ordering;
import org.hibernate.type.IntegerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, IntegerType> {
}
