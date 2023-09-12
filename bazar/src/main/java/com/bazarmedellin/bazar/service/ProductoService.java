package com.bazarmedellin.bazar.service;

import com.bazarmedellin.bazar.model.Producto;
import com.bazarmedellin.bazar.model.Venta;
import com.bazarmedellin.bazar.repository.IProductoRepository;
import com.bazarmedellin.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository iProductoRepository;


    @Override
    public void saveProducto(Producto producto) {
        iProductoRepository.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return iProductoRepository.findAll();
    }

    @Override
    public Producto getProducto(Long idProducto) {
        return iProductoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public void deleteProducto(Long idProducto) {
        iProductoRepository.deleteById(idProducto);
    }

    @Override
    public void editProducto(Long idProducto, Producto producto) {
        Producto productoEditar  = this.getProducto(idProducto);
        productoEditar.setCodigoProducto(producto.getCodigoProducto());
        productoEditar.setCosto(producto.getCosto());
        productoEditar.setMarca(producto.getMarca());
        productoEditar.setNombre(producto.getNombre());
        productoEditar.setCantidadDisponible(producto.getCantidadDisponible());
        this.saveProducto(productoEditar);
    }
}
