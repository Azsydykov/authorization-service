package kg.mogacom.authorizationservice.dao;

import kg.mogacom.authorizationservice.models.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRep extends JpaRepository<Users, Long> {

}
