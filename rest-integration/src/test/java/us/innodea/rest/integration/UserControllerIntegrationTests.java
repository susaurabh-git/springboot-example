package us.innodea.rest.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import us.innodea.rest.integration.model.Users;

@SpringBootTest(classes = RestApplication.class, 
		webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTests 
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "classpath:user-schema.sql", "classpath:user-data.sql" })
	@Test
	public void testAllUsers() 
	{
		assertTrue(
				this.restTemplate
					.getForObject("http://localhost:" + port + "/users", Users.class)
					.getUserList().size() == 3);
	}

}
