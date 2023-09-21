package com.hackaboss.ProyectoGrupo6.Dto.Seguridad;

import com.hackaboss.ProyectoGrupo6.Dto.Component.IGenericDto;

public interface IEmpleadoDto extends IGenericDto {
    String getNombreEmpleado();
    String getCodigoEmpleado();
    String getTelefonoHotel();
}
