package com.hackaboss.ProyectoGrupo6.IRepository.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Empleado;
import com.hackaboss.ProyectoGrupo6.IRepository.Component.IBaseRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends IBaseRepository<Empleado, Long> {



}
