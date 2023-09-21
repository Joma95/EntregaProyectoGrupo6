package com.hackaboss.ProyectoGrupo6.Service.Component;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;
import com.hackaboss.ProyectoGrupo6.IRepository.Component.IBaseRepository;
import com.hackaboss.ProyectoGrupo6.IService.Component.IBaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaseService <T extends IdentificadorId> implements IBaseService<T> {

    @Autowired
    protected IBaseRepository<T, Long> repositoryBaseModel;

    @Override
    public List<T> all() {
        return repositoryBaseModel.findAll();
    }

    @Override
    public List<T> findByStateTrue() {
        return repositoryBaseModel.findAll();
    }

    @Override
    public T findById(Long id) throws Exception {
        Optional<T> op = repositoryBaseModel.findById(id);

        if(op.isEmpty()){
            throw new Exception("Registro no encontrado");
        }

        return op.get();
    }

    @Override
    public T save(T entity) throws Exception {
        // entity.setFechaAsignacion(LocalDateTime.now());
        return repositoryBaseModel.save(entity);
    }

    @Override
    public void update(Long id, T entity) throws Exception {
        Optional<T> op = repositoryBaseModel.findById(id);

        if(op.isEmpty()){
            throw new Exception("Registro no encontrado");
        }

        T entityUpdate = op.get();

        String[] ignoreProperties = {"id"};
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);

        // entityUpdate.setFechaModificacion(LocalDateTime.now());
        repositoryBaseModel.save(entityUpdate);
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<T> op = repositoryBaseModel.findById(id);

        if(op.isEmpty()){
            throw new Exception("Registro no encontrado");
        }

        T entityUpdate = op.get();
        // entityUpdate.setFechaDesignacion(LocalDateTime.now());

        repositoryBaseModel.save(entityUpdate);
    }
}
