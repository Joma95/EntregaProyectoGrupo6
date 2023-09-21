package com.hackaboss.ProyectoGrupo6.IRepository.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Habitacion;
import com.hackaboss.ProyectoGrupo6.IRepository.Component.IBaseRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabitacionRepository extends IBaseRepository<Habitacion, Long> {



}
