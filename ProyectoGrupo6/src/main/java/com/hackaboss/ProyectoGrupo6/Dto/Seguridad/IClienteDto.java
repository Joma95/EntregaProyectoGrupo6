package com.hackaboss.ProyectoGrupo6.Dto.Seguridad;

import com.hackaboss.ProyectoGrupo6.Dto.Component.IGenericDto;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Reserva;

import java.util.List;


public interface IClienteDto extends IGenericDto {
    String getNombreCliente();
    String getDni();
    String getDireccion();
    String getTelefono();
    List<Reserva> getReservas();
}
