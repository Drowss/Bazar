package com.bazarmedellin.bazar.controller;

import com.bazarmedellin.bazar.dto.VentaProdClienteDTO;
import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.model.Venta;
import com.bazarmedellin.bazar.model.VentaSummary;
import com.bazarmedellin.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService iVentaService;

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta) {
        iVentaService.saveVenta(venta);
        return "Se ha creado la venta exitosamente";
    }

    @GetMapping("/ventas")
    public List<Venta> getVentas() {
        return iVentaService.getVentas();
    }

    @GetMapping("/ventas/{idVenta}")
    public Venta getVenta(@PathVariable Long idVenta) {
        return iVentaService.getVenta(idVenta);
    }

    @DeleteMapping("/ventas/eliminar/{idVenta}")
    public String deleteVenta(@PathVariable Long idVenta) {
        iVentaService.deleteVenta(idVenta);
        return "La venta ha sido eliminada satisfactoriamente";
    }

    @PutMapping("/ventas/editar/{idVenta}")
    public String editVenta(@PathVariable Long idVenta, @RequestBody Venta venta) {
        iVentaService.editVenta(idVenta, venta);
        return "La venta ha sido editada satisfactoriamente";
    }

    @GetMapping("/ventas/productos/{idVenta}")
    public List<String> getVentaProductos(@PathVariable Venta idVenta) {
        return iVentaService.getListaProductosVenta(idVenta);
    }

    @GetMapping("/venta/{fecha_venta}")
    public List<Long> getFechaVentas(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha_venta){
        return iVentaService.getFechaVentas(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentaProdClienteDTO getMayorVenta(){
        return iVentaService.getMayorVenta();
    }
}
