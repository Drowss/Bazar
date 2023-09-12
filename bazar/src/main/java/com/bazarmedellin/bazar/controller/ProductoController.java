package com.bazarmedellin.bazar.controller;

import com.bazarmedellin.bazar.model.Producto;
import com.bazarmedellin.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto){
        iProductoService.saveProducto(producto);
        return "Se ha creado el producto exitosamente";
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return iProductoService.getProductos();
    }

    @GetMapping("/productos/{idProducto}")
    public Producto getProducto(@PathVariable Long idProducto){
        return iProductoService.getProducto(idProducto);
    }

    @DeleteMapping("/productos/eliminar/{idProducto}")
    public String deleteProducto(@PathVariable Long idProducto){
        iProductoService.deleteProducto(idProducto);
        return "El producto ha sido eliminado satisfactoriamente";
    }

    @PutMapping("/productos/editar/{idProducto}")
    public String editProducto(@PathVariable Long idProducto, @RequestBody Producto producto){
        iProductoService.editProducto(idProducto, producto);
        return "El producto ha sido editado satisfactoriamente";
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getMenorStockCinco(){
        List<Producto> productos = iProductoService.getProductos();
        List<Producto> listaProductos = new ArrayList<>();

        for (Producto producto : productos){
            if (producto.getCantidadDisponible() < 5){
                listaProductos.add(producto);
            }
        }
        return listaProductos;
    }
}
