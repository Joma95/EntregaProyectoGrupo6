package com.hackaboss.ProyectoGrupo6.Controller.Seguridad;


import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Empleado;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Habitacion;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Reserva;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IClienteRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IEmpleadoRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IHabitacionRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IReservaRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    // Atributos de los repositorios
    private final IReservaRepository reservaRepository;
    private final IClienteRepository clienteRepository;
    private final IHabitacionRepository habitacionRepository;
    private final IEmpleadoRepository empleadoRepository;

    /**
     * Constructor con los repositorios que se van a usar
     * @param reservaRepository Repositorio de la entidad Reserva
     * @param clienteRepository Repositorio de la entidad Cliente
     * @param habitacionRepository Repositorio de la entidad Habitacion
     * @param empleadoRepository Repositorio de la entidad Empleado
     */
    @Autowired
    public ReservaController(IReservaRepository reservaRepository, IClienteRepository clienteRepository, IHabitacionRepository habitacionRepository, IEmpleadoRepository empleadoRepository) {
        this.reservaRepository = reservaRepository;
        this.clienteRepository = clienteRepository;
        this.habitacionRepository = habitacionRepository;
        this.empleadoRepository = empleadoRepository;
    }
}
