package com.hackaboss.ProyectoGrupo6.Controller.Seguridad;


import com.hackaboss.ProyectoGrupo6.Dto.Seguridad.HabitacionDisponibleDTO;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Habitacion;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IClienteRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    // Atributo con el repositorio de Habitacion
    private final IHabitacionRepository habitacionRepository;

    /**
     * Constructor de HabitacionController
     * @param habitacionRepository Repositorio de la entidad Habitacion
     */
    @Autowired
    public HabitacionController(IHabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }


    /**
     * Petición POST que registra una habitación en la base de datos
     * @param habitacion
     * @return
     */
    @PostMapping("/crear")
    public Habitacion crearHabitacion(@RequestBody Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    /**
     * Petición GET que muestra el estado de disponibilidad de todas las habitaciones, incluyendo el número y el piso
     * en el que se encuentra cada habitación
     * @return Mensaje de error o éxito
     */
    @GetMapping("/disponibilidad")
    public ResponseEntity<List<HabitacionDisponibleDTO>> obtenerDisponibilidadHabitaciones(){
        List<Habitacion> habitaciones = habitacionRepository.findAll();
        List<HabitacionDisponibleDTO> habitacionesDisponibles = new ArrayList<>();

        for(Habitacion habitacion: habitaciones){
            HabitacionDisponibleDTO dto = new HabitacionDisponibleDTO(habitacion.getId(), habitacion.getNumeroHabitacion(), habitacion.getPisoHabitacion(), habitacion.isDisponibilidad());
            habitacionesDisponibles.add(dto);
        }

        return ResponseEntity.ok(habitacionesDisponibles);
    }

}
