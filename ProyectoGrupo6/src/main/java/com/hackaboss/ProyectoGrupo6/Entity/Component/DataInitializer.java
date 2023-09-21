package com.hackaboss.ProyectoGrupo6.Entity.Component;

import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Empleado;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Habitacion;
import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Reserva;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IClienteRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IEmpleadoRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IHabitacionRepository;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IClienteRepository clienteRepository;
    private final IHabitacionRepository habitacionRepository;
    private final IEmpleadoRepository empleadoRepository;
    private final IReservaRepository reservaRepository;

    @Autowired
    public DataInitializer(IClienteRepository clienteRepository, IHabitacionRepository habitacionRepository, IEmpleadoRepository empleadoRepository, IReservaRepository reservaRepository) {
        this.clienteRepository = clienteRepository;
        this.habitacionRepository = habitacionRepository;
        this.empleadoRepository = empleadoRepository;
        this.reservaRepository = reservaRepository;
    }

    /**
     * Método que introduce datos base en la base de datos cada vez que se ejecuta el proyecto
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // Agregamos datos de base a la tabla Cliente
        Cliente cliente1 = new Cliente("Juanito", "87462817G", "c/ La robla nº 3", "497613498");
        Cliente cliente2 = new Cliente("Pepita", "12394763V", "C/ San Martín nº 5", "197314682");
        Cliente cliente3 = new Cliente("Luis", "97414650J", "C/ Vega nº 2", "461387946");

        Habitacion habitacion1 = new Habitacion("4", "5", 3, "suite", "normal", false);
        Habitacion habitacion2 = new Habitacion("8", "4", 4, "simple", "premium", true);
        Habitacion habitacion3 = new Habitacion("6", "3", 2, "simple", "premium", true);
        Habitacion habitacion4 = new Habitacion("3", "1", 4, "doble", "normal", true);
        Habitacion habitacion5 = new Habitacion("7", "2", 1, "suite", "normal", false);
        Habitacion habitacion6 = new Habitacion("1", "5", 3, "simple", "premium", true);
        Habitacion habitacion7 = new Habitacion("2", "4", 2, "doble", "normal", true);
        Habitacion habitacion8 = new Habitacion("9", "3", 4, "suite", "normal", false);

        Empleado empleado1 = new Empleado("Pedro Delgado", "6789", "111555999");
        Empleado empleado2 = new Empleado("Lorena Sánchez", "1234", "111555999");
        Empleado empleado3 = new Empleado("Carol Pérez", "4567", "111555999");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Reserva reserva1 = new Reserva(cliente2, habitacion1, empleado2, LocalDate.parse("2023-10-21", formatter), LocalDate.parse("2023-10-21", formatter));
        Reserva reserva2 = new Reserva(cliente3, habitacion5, empleado1, LocalDate.parse("2023-11-15", formatter), LocalDate.parse("2023-11-20", formatter));
        Reserva reserva3 = new Reserva(cliente1, habitacion8, empleado3, LocalDate.parse("2023-09-17", formatter), LocalDate.parse("2023-09-23", formatter));


        // Guarda los datos en la base de datos
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        clienteRepository.save(cliente3);

        habitacionRepository.save(habitacion1);
        habitacionRepository.save(habitacion2);
        habitacionRepository.save(habitacion3);
        habitacionRepository.save(habitacion4);
        habitacionRepository.save(habitacion5);
        habitacionRepository.save(habitacion6);
        habitacionRepository.save(habitacion7);
        habitacionRepository.save(habitacion8);

        empleadoRepository.save(empleado1);
        empleadoRepository.save(empleado2);
        empleadoRepository.save(empleado3);

        reservaRepository.save(reserva1);
        reservaRepository.save(reserva2);
        reservaRepository.save(reserva3);
    }
}
