package com.bazarmedellin.bazar.service;

import com.bazarmedellin.bazar.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;

public interface IProductoService {

    void saveProducto(Producto producto);
    List<Producto> getProductos();
    Producto getProducto(Long idProducto);
    void deleteProducto(Long idProducto);
    void editProducto(Long idProducto, Producto producto);
}
