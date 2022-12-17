package kg.mogacom.authorizationservice.mappers;

import kg.mogacom.authorizationservice.models.Account;
import kg.mogacom.authorizationservice.models.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountDto accountDto);

    AccountDto toDto(Account account);

    List<AccountDto> toDto(List<Account> all);
}
