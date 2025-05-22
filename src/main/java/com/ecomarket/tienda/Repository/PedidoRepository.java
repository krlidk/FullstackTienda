package com.ecomarket.tienda.Repository;
import com.ecomarket.tienda.Model.Pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    // buscar pedido por ID
    @Query("SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    List<Pedido> findByIdPedido(Integer idPedido);

    //eliminar pedido por ID
    List<Pedido> deleteByIdPedido(Integer idPedido);
    

    List<Pedido> findByTiendaIdTienda(Integer idTienda);
    // buscar pedidos por ID de tienda

    @Query("SELECT p FROM Pedido p WHERE LOWER(p.nombreCliente) LIKE LOWER(CONCAT('%',:nombreCliente,'%'))")
    List<Pedido> findByNombreCliente(String nombreCliente);
    // buscar pedidos por nombre de cliente

    @Query("SELECT p FROM Pedido p WHERE LOWER(p.estadoPedido) LIKE LOWER(CONCAT('%',:estadoPedido,'%'))")
    List<Pedido> findByEstadoPedido(String estadoPedido);

    //buscar pedidos por fecha
    @Query("SELECT p FROM Pedido p WHERE LOWER(p.fechaPedido) LIKE LOWER(CONCAT('%',:fechaPedido,'%'))")
    List<Pedido> findByFechaPedido(String fechaPedido);

    //buscar pedidos por rango de fechas
    //@Query("SELECT p FROM Pedido a WHERE LOWER(a.fechaPedido) BETWEEN LOWER(CONCAT('%',:fechaInicio,'%')) AND LOWER(CONCAT('%',:fechaFin,'%'))")
    //List<Pedido> findByRangoFechas(String fechaInicio, String fechaFin);

    //buscar pedidos por rango de precios
    @Query("SELECT p FROM Pedido p WHERE p.totalPedido BETWEEN :precioMin AND :precioMax")
    List<Pedido> findByRangoPrecios(Double precioMin, Double precioMax);
}
