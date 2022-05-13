package us.innodea.rest.redis.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 5688527520885595391L;
    private String id;
    private String firstName;
    private String lastName;
}
