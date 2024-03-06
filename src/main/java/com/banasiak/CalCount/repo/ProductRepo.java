package com.banasiak.CalCount.repo;

import com.banasiak.CalCount.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {


    @Query("from Product where kcal>?1 order by name")
    List<Product> findProductWhereKcal(double kcal);


    @Query("from  Product  where user.userId = ?1")
    List<Product> findAllForUser(Long id);

}
