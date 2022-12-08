package kg.mogacom.authorizationservice.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users{
    @Id
    @GeneratedValue  //ключ будет генерироваться
    Long id;
    String name;


    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    Date addDate;
    Date updateDate;
    boolean active;

}
