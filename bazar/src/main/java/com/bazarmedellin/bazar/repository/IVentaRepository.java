package com.bazarmedellin.bazar.repository;

import com.bazarmedellin.bazar.model.Cliente;
import com.bazarmedellin.bazar.model.Producto;
import com.bazarmedellin.bazar.model.Venta;
import com.bazarmedellin.bazar.model.VentaSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT p.nombre FROM Producto p WHERE p.venta = :id_venta")
    List<String> findProductoNombresByVentaId(@Param("id_venta") Venta idVenta);

    @Query("SELECT SUM(producto.costo) from Producto producto where producto.venta.fechaVenta = :fechaVenta")
    Long findMontoCantidadVentas(@Param("fechaVenta")LocalDate fechaVenta);

    @Query("SELECT count(*) from Producto producto where producto.venta.fechaVenta = :fechaVenta")
    Long findCantidadVentas(@Param("fechaVenta")LocalDate fechaVenta);
//    SELECT codigo_venta, total, producto.nombre, cliente.nombre, apellido FROM producto INNER JOIN venta on venta_codigo_venta = venta.codigo_venta INNER JOIN cliente on venta.un_cliente_id_cliente = cliente.id_cliente WHERE venta.total = (SELECT MAX(total) from venta);
    @Query(value = "SELECT codigo_venta, total, nombre, apellido from venta INNER JOIN cliente ON total = (SELECT MAX(total) from venta) where venta.un_cliente_id_cliente = cliente.id_cliente", nativeQuery = true)
    List<String> findTotalMayors();

    @Query(value = "SELECT producto.nombre, count(*) FROM producto INNER JOIN venta on venta_codigo_venta = venta.codigo_venta INNER JOIN cliente on venta.un_cliente_id_cliente = cliente.id_cliente WHERE venta.total = (SELECT MAX(total) from venta)", nativeQuery = true)
    List<String> findListaProductos();
}
