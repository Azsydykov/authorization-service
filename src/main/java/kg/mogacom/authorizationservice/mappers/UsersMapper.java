package kg.mogacom.authorizationservice.mappers;
import kg.mogacom.authorizationservice.models.entities.Users;
import kg.mogacom.authorizationservice.models.dto.UsersDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsersMapper extends BaseMapper<Users, UsersDto>{
    UsersMapper INSTANCE= Mappers.getMapper(UsersMapper.class);

}
