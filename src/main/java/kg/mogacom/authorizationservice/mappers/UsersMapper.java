package kg.mogacom.authorizationservice.mappers;
import kg.mogacom.authorizationservice.models.Users;
import kg.mogacom.authorizationservice.models.dto.UsersDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsersMapper {
    UsersMapper INSTANCE= Mappers.getMapper(UsersMapper.class);
    Users toEntity(UsersDto userDto);
    UsersDto toDto(Users user);

    List<UsersDto> toDto(List<Users> all);
}
