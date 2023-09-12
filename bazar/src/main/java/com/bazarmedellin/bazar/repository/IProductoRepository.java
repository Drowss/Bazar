package com.bazarmedellin.bazar.repository;

import com.bazarmedellin.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
