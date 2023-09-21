package com.hackaboss.ProyectoGrupo6.Entity.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Habitacion extends IdentificadorId {
    private String numeroHabitacion;
    private String pisoHabitacion;
    private int numeroCamas;
    private String tipoHabitacion;
    private String tarifa;
    private boolean disponibilidad;

    @OneToMany(mappedBy = "idHabitacion")
    private List<Reserva> reservas;

    public Habitacion() {
    }

    public Habitacion(String numeroHabitacion, String pisoHabitacion, int numeroCamas, String tipoHabitacion, String tarifa, boolean disponibilidad) {
        this.numeroHabitacion = numeroHabitacion;
        this.pisoHabitacion = pisoHabitacion;
        this.numeroCamas = numeroCamas;
        this.tipoHabitacion = tipoHabitacion;
        this.tarifa = tarifa;
        this.disponibilidad = disponibilidad;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public String getPisoHabitacion() {
        return pisoHabitacion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public String getTarifa() {
        return tarifa;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setPisoHabitacion(String pisoHabitacion) {
        this.pisoHabitacion = pisoHabitacion;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
