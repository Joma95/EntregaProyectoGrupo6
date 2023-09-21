package com.hackaboss.ProyectoGrupo6.Entity.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Empleado extends IdentificadorId {

    private String nombreEmpleado;
    private String codigoEmpleado;
    private String telefonoHotel;

    @OneToMany(mappedBy = "idEmpleado")
    private List<Reserva> reservas;

    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String codigoEmpleado, String telefonoHotel) {
        this.nombreEmpleado = nombreEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.telefonoHotel = telefonoHotel;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getTelefonoHotel() {
        return telefonoHotel;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setTelefonoHotel(String telefonoHotel) {
        this.telefonoHotel = telefonoHotel;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
