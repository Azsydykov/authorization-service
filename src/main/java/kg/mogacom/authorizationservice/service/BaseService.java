package kg.mogacom.authorizationservice.service;

import java.util.List;

public interface BaseService <T>{
    T save(T t);
    T findById(Long id);
    T delete(Long id);
    List<T> findAll();



}
