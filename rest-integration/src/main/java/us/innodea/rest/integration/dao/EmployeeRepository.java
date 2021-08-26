package us.innodea.rest.integration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import us.innodea.rest.integration.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long>
{
	 
}
