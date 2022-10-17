package com.product.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer catgory_id;

    @NotNull
    @Column(name = "category")
    private String Category;

    @Column(name = "status")
    @Min(value = 0, message = "Status must be zero or 1")
    @Max(value = 1, message = "Status must be zero or 1")
    @JsonIgnore
    private Integer status;

    public Category(){

    }

    @Override
    public String toString() {
        return "Category{" +
                "catgory_id=" + catgory_id +
                ", Category='" + Category + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getCatgory_id() {
        return catgory_id;
    }

    public void setCatgory_id(Integer catgory_id) {
        this.catgory_id = catgory_id;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
