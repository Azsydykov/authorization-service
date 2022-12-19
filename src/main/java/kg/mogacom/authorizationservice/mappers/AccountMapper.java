package kg.mogacom.authorizationservice.mappers;

import kg.mogacom.authorizationservice.models.entities.Account;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper extends BaseMapper<Account, AccountDto>{
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

//    Account toEntity(AccountDto accountDto);
//
//    AccountDto toDto(Account account);
//
//    List<AccountDto> toDto(List<Account> all);
}
