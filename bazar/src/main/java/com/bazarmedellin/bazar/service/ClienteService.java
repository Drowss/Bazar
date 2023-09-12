package com.bazarmedellin.bazar.service;

import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository iClienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        iClienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return iClienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long idCliente) {
        return iClienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public void deleteCliente(Long idCliente) {
        iClienteRepository.deleteById(idCliente);
    }

    @Override
    public void editCliente(Long idCliente, Cliente cliente) {
        Cliente clienteEditar = this.getCliente(idCliente);
        clienteEditar.setIdCliente(cliente.getIdCliente());
        clienteEditar.setDni(cliente.getDni());
        clienteEditar.setNombre(cliente.getNombre());
        clienteEditar.setApellido(cliente.getApellido());
        this.saveCliente(clienteEditar);
    }
}
