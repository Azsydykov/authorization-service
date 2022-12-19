package kg.mogacom.authorizationservice.mappers;


import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public interface BaseMapper<E, D> {

    E toEntity(D d);

    D toDto(E e);

    List<E> toEntities(List<D> ds);
    List<D> toDtos (List<E> ds);

}
