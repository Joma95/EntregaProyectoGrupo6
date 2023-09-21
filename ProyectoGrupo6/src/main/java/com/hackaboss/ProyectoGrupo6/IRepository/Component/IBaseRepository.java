package com.hackaboss.ProyectoGrupo6.IRepository.Component;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepository  <T extends IdentificadorId, ID> extends JpaRepository<T, ID> {
}
