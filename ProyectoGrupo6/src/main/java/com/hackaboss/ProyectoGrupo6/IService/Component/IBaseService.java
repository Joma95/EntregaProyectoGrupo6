package com.hackaboss.ProyectoGrupo6.IService.Component;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;

import java.util.List;

public interface IBaseService <T extends IdentificadorId>{

    List<T> all();
    List<T> findByStateTrue();
    T findById(Long id) throws Exception;
    T save(T entity) throws Exception;
    void update(Long id, T entity) throws Exception;
    void delete(Long id) throws Exception;

}
