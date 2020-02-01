package com.api.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.model.entity.VoteEntity;

@Repository
public interface VoteDao extends JpaRepository<VoteEntity, Integer>{
	
	@Query(value = "select * from vote  v	 where v.post_id like ?",  nativeQuery = true)
	List<VoteEntity> findAllByPostId(Integer postId);	

}
