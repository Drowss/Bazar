package com.bazarmedellin.bazar.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VentaProdClienteDTO {

    private Long idVenta;
    private Double totalMayor;
    private Long cantidadProductos;
    private List<String> listaProductos;
    private String nombreCliente;
    private String apellidoCliente;
}
