package com.hackaboss.ProyectoGrupo6.Dto.Seguridad;

/**
 * Cuerpo de los datos que se solicitan para comprobar la disponibilidad de las habitaciones en
 * HabitacionController.obtenerDisponibilidadHabitaciones()
 */
public class HabitacionDisponibleDTO {
    private Long id;
    private String numeroHabitacion;
    private String pisoHabitacion;
    private boolean disponibilidad;

    public HabitacionDisponibleDTO() {
    }

    public HabitacionDisponibleDTO(Long id, String numeroHabitacion, String pisoHabitacion, boolean disponibilidad) {
        this.id = id;
        this.numeroHabitacion = numeroHabitacion;
        this.pisoHabitacion = pisoHabitacion;
        this.disponibilidad = disponibilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getPisoHabitacion() {
        return pisoHabitacion;
    }

    public void setPisoHabitacion(String pisoHabitacion) {
        this.pisoHabitacion = pisoHabitacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
