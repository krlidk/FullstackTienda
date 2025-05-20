package com.ecomarket.tienda.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.tienda.Model.Pedido;
import com.ecomarket.tienda.Repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    } // Listar todos los pedidos

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    } // Guardar un pedido

    public Pedido buscarPedido(Integer idPedido) {
        return pedidoRepository.findByIdPedido(idPedido)
                .stream()
                .findFirst()
                .orElse(null);
    } // Buscar un pedido por ID

    public void eliminarPedido(Integer idPedido) {
        pedidoRepository.deleteByIdPedido(idPedido);
    } // Eliminar un pedido por ID

    public List<Pedido> buscarPedidosPorTienda(Integer idTienda) {
        return pedidoRepository.findByTiendaIdTienda(idTienda);
    } // Buscar pedidos por ID de tienda

    public List<Pedido> buscarPedidosPorCliente(String nombreCliente) {
        return pedidoRepository.findByNombreCliente(nombreCliente);
    } // Buscar pedidos por nombre de cliente

    public List<Pedido> buscarPedidosPorEstado(String estadoPedido) {
        return pedidoRepository.findByEstadoPedido(estadoPedido);
    } // Buscar pedidos por estado de pedido

    public List<Pedido> buscarPedidosPorFecha(String fechaPedido) {
        return pedidoRepository.findByFechaPedido(fechaPedido);
    } // Buscar pedidos por fecha de pedido

    public List<Pedido> buscarPedidosPorRangoPrecios(Double precioMin, Double precioMax) {
        return pedidoRepository.findByRangoPrecios(precioMin, precioMax);
    } // Buscar pedidos por rango de precios

    //obtener totalPedido sumando todos los productos del pedido
    public Double calcularTotalPedido(Pedido pedido) {
        return pedido.getProductos().stream()
                .mapToDouble(producto -> producto.getPrecioProducto())
                .sum();
    } // Calcular el total del pedido

}
