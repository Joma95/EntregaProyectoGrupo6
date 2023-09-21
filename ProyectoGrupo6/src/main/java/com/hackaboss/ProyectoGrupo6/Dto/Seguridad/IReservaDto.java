package com.hackaboss.ProyectoGrupo6.Dto.Seguridad;

import com.hackaboss.ProyectoGrupo6.Dto.Component.IGenericDto;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Empleado;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Habitacion;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface IReservaDto extends IGenericDto {
    Cliente getIdCliente();
    Habitacion getIdHabitacion();
    Empleado getIdEmpleado();
    LocalDate getFechaEntrada();
    LocalDate getFechaSalida();
    List<Reserva> getReservas();
}
