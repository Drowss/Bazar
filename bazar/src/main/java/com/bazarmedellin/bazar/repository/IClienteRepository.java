package com.bazarmedellin.bazar.repository;

import com.bazarmedellin.bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
