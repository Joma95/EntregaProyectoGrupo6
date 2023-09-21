package com.hackaboss.ProyectoGrupo6.IRepository.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.IRepository.Component.IBaseRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface IClienteRepository extends IBaseRepository<Cliente, Long> {





}
