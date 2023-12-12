package com.innodeatech.graphql.dao;

import com.innodeatech.graphql.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long>
{
	 
}
