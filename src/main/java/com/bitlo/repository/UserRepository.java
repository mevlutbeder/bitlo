package com.bitlo.repository;

import com.bitlo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   // Page<User> findAllOrOrderByDateCreated(Pageable pageable);

    User findUserById(@Param("id") Long id);

    User findByUsername(@Param("username") String username);

}
