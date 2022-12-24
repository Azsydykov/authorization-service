package kg.mogacom.authorizationservice.models.entities;


import kg.mogacom.authorizationservice.models.entities.Account;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity   //создает нам такблицы в postgres
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ключ будет генерироваться
    Long id;
    String name;


    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    Date addDate;
    Date updateDate;
    boolean active;



}
