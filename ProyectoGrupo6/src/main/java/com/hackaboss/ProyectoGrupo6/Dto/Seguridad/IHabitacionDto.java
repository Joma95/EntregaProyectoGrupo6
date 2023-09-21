package com.hackaboss.ProyectoGrupo6.Dto.Seguridad;

import com.hackaboss.ProyectoGrupo6.Dto.Component.IGenericDto;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Reserva;

import java.util.List;

public interface IHabitacionDto extends IGenericDto {
    String getNumeroHabitacion();
    String getPisoHabitacion();
    int getNumeroCamas();
    String getTipoHabitacion();
    String getTarifa();
    boolean isDisponibilidad();
    List<Reserva> getReservas();
}
