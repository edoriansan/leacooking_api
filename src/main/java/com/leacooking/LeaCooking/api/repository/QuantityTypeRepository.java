package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.QuantityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityTypeRepository extends JpaRepository<QuantityType, Long> {
}
