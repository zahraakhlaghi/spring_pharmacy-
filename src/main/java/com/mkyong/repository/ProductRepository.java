package com.mkyong.repository;

import com.mkyong.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select e from #{#entityName} e where e.name like %?1% ")
    List<Product> search(String name);



}
