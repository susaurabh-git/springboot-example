package us.innodea.rest.integration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import us.innodea.rest.integration.model.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> 
{
	 
}
