package kg.mogacom.authorizationservice.dao;

import kg.mogacom.authorizationservice.models.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRep extends JpaRepository<Account,Long> {

   Optional<Account>  findByLogin(String login);

   @Query("select a from Account a inner join Users u on a.id=u.account.id where u.name=:name and u.active=:active")
   Account findByUserName(String name, boolean active);

   @Query(value = "SELECT * FROM account INNER JOIN users on account.id=users.id WHERE users.id=:id", nativeQuery = true)
   Account findbyUserId(Long id);

}
