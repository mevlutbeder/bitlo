package com.bitlo.repository;

import com.bitlo.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType,String> {

    TransactionType findAllByType(@Param("type") String type);

}
