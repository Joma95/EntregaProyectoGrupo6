package com.hackaboss.ProyectoGrupo6.Controller.Seguridad;

import com.hackaboss.ProyectoGrupo6.Dto.Seguridad.ReservaRequestDTO;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Empleado;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Habitacion;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Reserva;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IClienteRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IEmpleadoRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IHabitacionRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IReservaRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    // Atributos de los repositorios que se van a usar
    private final IEmpleadoRepository empleadoRepository;
    private final IClienteRepository clienteRepository;
    private final IHabitacionRepository habitacionRepository;
    private final IReservaRepository reservaRepository;

    /**
     * Constructor de EmpleadoController
     * @param empleadoRepository Repositorio de la entidad Empleado
     * @param clienteRepository Repositorio de la entidad Cliente
     * @param habitacionRepository Repositorio de la entidad Habitación
     * @param reservaRepository Repositorio de la entidad Reserva
     */
    public EmpleadoController(IEmpleadoRepository empleadoRepository, IClienteRepository clienteRepository, IHabitacionRepository habitacionRepository, IReservaRepository reservaRepository) {
        this.empleadoRepository = empleadoRepository;
        this.clienteRepository = clienteRepository;
        this.habitacionRepository = habitacionRepository;
        this.reservaRepository = reservaRepository;
    }

    /**
     * Petición POST que establece una reserva asignando una habitación a un cliente
     * @param reservaRequestDTO Cuerpo de los datos que se usarán para la petición
     * @return Mensaje de éxito o error al introducir los datos
     */
    @PostMapping("/asignarHabitacion")
    public ResponseEntity<String> asignarHabitacion(@RequestBody ReservaRequestDTO reservaRequestDTO){
        // Obtener el cliente y la habitación por sus IDs


        Cliente cliente = clienteRepository.findById(reservaRequestDTO.getIdCliente()).orElse(null);
        Habitacion habitacion = habitacionRepository.findById(reservaRequestDTO.getIdHabitacion()).orElse(null);
        Empleado empleado = empleadoRepository.findById(reservaRequestDTO.getIdEmpleado()).orElse(null);
        String stringFechaEntrada = reservaRequestDTO.getFechaEntrada();
        String stringFechaSalida = reservaRequestDTO.getFechaSalida();

        // Comprobar si el cliente, la habitación o el empleado ya existen
        if(cliente == null){
            return ResponseEntity.badRequest().body("ERROR: Cliente no encontrado");
        }
        if(habitacion == null){
            return ResponseEntity.badRequest().body("ERROR: Habitación no encontrada");
        }
        if(empleado == null){
            return ResponseEntity.badRequest().body("ERROR: Empleado no encontrado");
        }

        // Comprobar si la habitación está disponible
        if(!habitacion.isDisponibilidad()){
            return ResponseEntity.badRequest().body("ERROR: La habitación no está disponible");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEntrada = LocalDate.parse(stringFechaEntrada, formatter);
        LocalDate fechaSalida = LocalDate.parse(stringFechaSalida, formatter);
        if(fechaEntrada.isBefore(LocalDate.now()) || fechaSalida.isBefore(LocalDate.now())){
            return ResponseEntity.badRequest().body("ERROR: Una de las dos fechas introducidas es anterior al día de hoy");
        }
        if(fechaEntrada.isAfter(fechaSalida)){
            return ResponseEntity.badRequest().body("ERROR: La fecha de entrada es posterior a la fecha de salida");
        }


        // Asignar el cliente, la habitación y el empleado a la reserva
        Reserva reserva = new Reserva(cliente, habitacion, empleado, fechaEntrada, fechaSalida);
        reservaRepository.save(reserva);

        // Cambiar el estado de disponibilidad a la habitacion
        habitacion.setDisponibilidad(false);
        habitacionRepository.save(habitacion);

        return ResponseEntity.ok("Habitación asignada con éxito");
    }

    @PutMapping("/cambiarFechasReserva/{idReserva}")
    public ResponseEntity<String> cambiarFechasReserva(@PathVariable Long idReserva, @RequestBody Map<String, String> body){

        Reserva reserva = reservaRepository.findById(idReserva).orElse(null);

        if(reserva == null){
            return ResponseEntity.notFound().build();
        }

        String nuevaFechaEntrada = body.get("nuevaFechaEntrada");
        String nuevaFechaSalida = body.get("nuevaFechaSalida");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaEntrada = LocalDate.parse(nuevaFechaEntrada, formatter);
        LocalDate fechaSalida = LocalDate.parse(nuevaFechaSalida, formatter);
        if(fechaEntrada.isBefore(LocalDate.now()) || fechaSalida.isBefore(LocalDate.now())){
            return ResponseEntity.badRequest().body("ERROR: Una de las dos fechas introducidas es anterior al día de hoy");
        }
        if(fechaEntrada.isAfter(fechaSalida)){
            return ResponseEntity.badRequest().body("ERROR: La fecha de entrada es posterior a la fecha de salida");
        }

        reserva.setFechaEntrada(fechaEntrada);
        reserva.setFechaSalida(fechaSalida);

        reservaRepository.save(reserva);

        return ResponseEntity.ok("Fechas de reserva actualizadas con éxito");
    }



    @DeleteMapping("eliminarReserva/{idReserva}")
    public ResponseEntity eliminarReserva(@PathVariable Long idReserva){
        Reserva reserva = reservaRepository.findById(idReserva).orElse(null);

        if(reserva == null){
            return ResponseEntity.notFound().build();
        }

        Habitacion habitacion = reserva.getIdHabitacion();
        habitacion.setDisponibilidad(true);
        habitacionRepository.save(habitacion);

        reservaRepository.delete(reserva);


        return ResponseEntity.ok("Reserva eliminada con éxito");
    }

}
