package com.api.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.api.model.entity.PostEntity;

public interface PostDao extends JpaRepository<PostEntity, Integer>{

}
