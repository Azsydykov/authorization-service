package kg.mogacom.authorizationservice.service;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import kg.mogacom.authorizationservice.models.request.AuthRequest;

public interface AccountService extends BaseService<AccountDto> {

    String auth(AuthRequest request);

    AccountDto findByUserName(String name, boolean active);

    AccountDto getByUserId(Long id);

}
