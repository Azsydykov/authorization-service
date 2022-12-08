package kg.mogacom.authorizationservice.dao;

import kg.mogacom.authorizationservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRep extends JpaRepository<Account,Long> {

    Account findByLogin(String login);

}
