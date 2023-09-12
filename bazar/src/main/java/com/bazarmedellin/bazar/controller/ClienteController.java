package com.bazarmedellin.bazar.controller;

import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.model.Producto;
import com.bazarmedellin.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        iClienteService.saveCliente(cliente);
        return "Se ha creado el cliente exitosamente";
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return iClienteService.getClientes();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente getCliente(@PathVariable Long idCliente){
        return iClienteService.getCliente(idCliente);
    }

    @DeleteMapping("/clientes/eliminar/{idCliente}")
    public String deleteCliente(@PathVariable Long idCliente){
        iClienteService.deleteCliente(idCliente);
        return "El cliente ha sido eliminado satisfactoriamente";
    }

    @PutMapping("/clientes/editar/{idCliente}")
    public String editCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente){
        iClienteService.editCliente(idCliente, cliente);
        return "El cliente ha sido editado satisfactoriamente";
    }
}
