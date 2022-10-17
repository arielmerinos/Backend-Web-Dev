package com.product.api.respository;


import com.product.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RepoCategory extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT * FROM category WHERE status = :status", nativeQuery = true)
    List<Category> findByStatus(@Param("status") Integer status);

    @Query(value = "SELECT * FROM category WHERE category_id = :category_id AND status = 1", nativeQuery = true)
    Category findByCategoryId(@Param("category_id") Integer category_id);

    @Query(value = "SELECT * FROM category WHERE category = :category", nativeQuery = true)
    Category findByCategory(@Param("category") String category);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO category (category, status) values(:category, 1)", nativeQuery = true)
    void createCategory(@Param("category") String region);

    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET category = :category WHERE category_id= :category_id", nativeQuery = true)
    Integer updateCategory(@Param("category") String region, @Param("category_id") Integer category_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET status = 1 WHERE category_id= :category_id", nativeQuery = true)
    Integer activateCategory(@Param("category_id") Integer category_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE category SET status = 0 WHERE category_id= :category_id", nativeQuery = true)
    void deleteByIdCategory(@Param("category_id") Integer category_id);


}
