package com.bazarmedellin.bazar.service;

import com.bazarmedellin.bazar.dto.VentaProdClienteDTO;
import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.model.Producto;
import com.bazarmedellin.bazar.model.Venta;
import com.bazarmedellin.bazar.model.VentaSummary;
import com.bazarmedellin.bazar.repository.IProductoRepository;
import com.bazarmedellin.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository iVentaRepository;

    @Autowired
    private IProductoRepository iProductoRepository;
    @Override
    public void saveVenta(Venta venta) {
        iVentaRepository.save(venta);
    } 

    @Override
    public List<Venta> getVentas() {
        return iVentaRepository.findAll();
    }

    @Override
    public Venta getVenta(Long idVenta) {
        return iVentaRepository.findById(idVenta).orElse(null);
    }

    @Override  
    public void deleteVenta(Long idVenta) {
        iVentaRepository.deleteById(idVenta);
    }

    @Override
    public void editVenta(Long idVenta, Venta venta) {
        Venta ventaEditar = this.getVenta(idVenta);
        ventaEditar.setFechaVenta(venta.getFechaVenta());
        ventaEditar.setTotal(venta.getTotal());
        ventaEditar.setListaProductos(venta.getListaProductos());
        ventaEditar.setUnCliente(venta.getUnCliente());
        this.saveVenta(ventaEditar);
    }

    @Override
    public List<String> getListaProductosVenta(Venta idVenta) {
        return iVentaRepository.findProductoNombresByVentaId(idVenta);
    }

    @Override
    public List<Long> getFechaVentas(LocalDate fechaVenta) {
        List<Long> listaMontoVentas = new ArrayList<>();
        listaMontoVentas.add(iVentaRepository.findMontoCantidadVentas(fechaVenta));
        listaMontoVentas.add(iVentaRepository.findCantidadVentas(fechaVenta));
        return listaMontoVentas;
    }

    @Override
    public VentaProdClienteDTO getMayorVenta() {
        VentaProdClienteDTO ventaProdClienteDTO = new VentaProdClienteDTO();
        ArrayList<String> valores = new ArrayList<>();
        ArrayList<String> valores2 = new ArrayList<>();
        Collections.addAll(valores, iVentaRepository.findTotalMayors().get(0).split(","));
        Collections.addAll(valores2, iVentaRepository.findListaProductos().get(0).split(","));
        System.out.println(iVentaRepository.findListaProductos());

        for (String valor : valores2){
            System.out.println(valor);
        }

        ventaProdClienteDTO.setIdVenta(Long.parseLong(valores.get(0)));
        ventaProdClienteDTO.setTotalMayor(Double.parseDouble(valores.get(1)));
        ventaProdClienteDTO.setNombreCliente(valores.get(2));
        ventaProdClienteDTO.setApellidoCliente(valores.get(3));
        return ventaProdClienteDTO;
    }
}
