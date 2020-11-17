package Data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.*;

@Getter @Setter @ToString
public class User {
    private String userUnqId;
    private String userName;
    private int userAge;
    private String userGender;
    private String userBirth;
}