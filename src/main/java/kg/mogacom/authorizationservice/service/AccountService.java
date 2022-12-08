package kg.mogacom.authorizationservice.service;
import kg.mogacom.authorizationservice.dao.AccountRep;
import kg.mogacom.authorizationservice.models.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService extends BaseService<Account> {

    Account login(String login, String password);

}
