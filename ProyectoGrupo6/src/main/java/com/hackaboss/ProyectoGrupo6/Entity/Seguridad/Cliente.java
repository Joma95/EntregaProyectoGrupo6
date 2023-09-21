package com.hackaboss.ProyectoGrupo6.Entity.Seguridad;

import com.hackaboss.ProyectoGrupo6.Entity.Component.IdentificadorId;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cliente extends IdentificadorId {

    private String nombreCliente;
    private String dni;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "idCliente")
    private List<Reserva> reservas;

    public Cliente() {
    }

    public Cliente(String nombreCliente, String dni, String direccion, String telefono) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
