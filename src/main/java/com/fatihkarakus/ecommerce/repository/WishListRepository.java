package com.fatihkarakus.ecommerce.repository;

import com.fatihkarakus.ecommerce.model.User;
import com.fatihkarakus.ecommerce.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
