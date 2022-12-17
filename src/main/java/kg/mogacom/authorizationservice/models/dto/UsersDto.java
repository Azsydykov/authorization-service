package kg.mogacom.authorizationservice.models.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsersDto {
    Long id;
    String name;
    AccountDto account;
    Date addDate;
    Date updateDate;
    boolean active;
}
