package com.bazarmedellin.bazar.service;

import com.bazarmedellin.bazar.dto.VentaProdClienteDTO;
import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.model.Producto;
import com.bazarmedellin.bazar.model.Venta;
import com.bazarmedellin.bazar.model.VentaSummary;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
        void saveVenta(Venta venta);
        List<Venta> getVentas();
        Venta getVenta(Long idVenta);
        void deleteVenta(Long idVenta);
        void editVenta(Long idVenta, Venta venta);
        List<String> getListaProductosVenta(Venta idVenta);
        List<Long> getFechaVentas(LocalDate fechaVenta);
        VentaProdClienteDTO getMayorVenta();
}
