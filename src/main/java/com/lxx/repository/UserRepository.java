package com.lxx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lxx.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserEntity, Integer>{

    @Query("select a from users a where a.name like %?1%")
     List<UserEntity> findByNameLike(String name);


}
