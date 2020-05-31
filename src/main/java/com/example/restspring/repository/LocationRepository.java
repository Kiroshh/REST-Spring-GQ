package com.example.restspring.repository;

import com.example.restspring.entity.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Long> {

    @Query("select d.id, d.address from Location d where d.id=:id")
    String findAddressById(Long id);
}
