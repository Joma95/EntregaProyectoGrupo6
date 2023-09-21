package com.hackaboss.ProyectoGrupo6.Entity.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reserva extends IdentificadorId {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente idCliente;

    @ManyToOne
    @JoinColumn(name = "habitacion_id")
    private Habitacion idHabitacion;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado idEmpleado;

    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva() {
    }

    public Reserva(Cliente idCliente, Habitacion idHabitacion, Empleado idEmpleado, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.idCliente = idCliente;
        this.idHabitacion = idHabitacion;
        this.idEmpleado = idEmpleado;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public Habitacion getIdHabitacion() {
        return idHabitacion;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdHabitacion(Habitacion idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
