package com.bazarmedellin.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    @OneToMany(mappedBy = "venta")
    private List<Producto> listaProductos;
    @OneToOne
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigoVenta, LocalDate fechaVenta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigoVenta = codigoVenta;
        this.fechaVenta = fechaVenta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

    public Venta(Long codigoVenta, Double total, String nombreCliente, String apellidoCliente) {
        this.codigoVenta = codigoVenta;
        this.total = total;
        this.unCliente = new Cliente();
        this.unCliente.setNombre(nombreCliente);
        this.unCliente.setApellido(apellidoCliente);
    }
}
