package com.bazarmedellin.bazar.service;

import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.model.Producto;

import java.util.List;

public interface IClienteService {

    void saveCliente(Cliente cliente);
    List<Cliente> getClientes();
    Cliente getCliente(Long idCliente);
    void deleteCliente(Long idCliente);
    void editCliente(Long idCliente, Cliente cliente);
}
