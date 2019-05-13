package com.mista.petroz.restfulwebservices.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mista
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
