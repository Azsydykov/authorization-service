package kg.mogacom.authorizationservice.models;
import kg.mogacom.authorizationservice.models.enums.AccountStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity   //создает нам такблицы в postgres
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account{
    @Id
    @GeneratedValue  //ключ будет генерироваться
    Long id;
    String login;
    String password;
    int count;
    AccountStatus status;
    Date addDate;
    Date updateDate;
    boolean active;

}
