package com.hackaboss.ProyectoGrupo6.Controller.Seguridad;


import com.hackaboss.ProyectoGrupo6.Entity.Seguridad.Cliente;
import com.hackaboss.ProyectoGrupo6.IRepository.Seguridad.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // Atributo de IClienteRepository
    private final IClienteRepository clienteRepository;

    // Constructor
    @Autowired
    public ClienteController(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    /**
     * Petición POST para crear un cliente en la base de datos
     * @param cliente Cliente a registrar
     * @return
     */
    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
