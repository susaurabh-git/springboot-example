package us.innodea.rest.redis.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CreateUserRequest implements Serializable {
    private static final long serialVersionUID = 7868658652239261022L;
    private String id;
    private String firstName;
    private String lastName;
}
