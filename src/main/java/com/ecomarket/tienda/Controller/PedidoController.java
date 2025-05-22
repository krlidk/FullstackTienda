package com.ecomarket.tienda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.tienda.Model.Pedido;
import com.ecomarket.tienda.Service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/pedidos") // URL base para el controlador de pedidos http://localhost:8080/api/v1/pedidos
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    //Listar todos los métodos HTTP del controlador
    @GetMapping
    public ResponseEntity<List<String>> listarMetodosDisponibles() {
        List<String> metodos = List.of(
            "GET /api/v1/pedidos - Lista los métodos disponibles",
            "GET /api/v1/pedidos/listar - Lista todos los pedidos",
            "GET /api/v1/pedidos/buscar - Busca un pedido por ID",
            "GET /api/v1/pedidos/buscarPorTienda - Busca pedidos por ID de tienda",
            "GET /api/v1/pedidos/buscarPorCliente - Busca pedidos por nombre de cliente",
            "GET /api/v1/pedidos/buscarPorEstado - Busca pedidos por estado de pedido",
            "GET /api/v1/pedidos/buscarPorFecha - Busca pedidos por fecha de pedido",
            "GET /api/v1/pedidos/buscarPorRangoPrecios - Busca pedidos por rango de precios",
            "POST /api/v1/pedidos/ingresar - Ingresa un nuevo pedido",
            "PUT /api/v1/pedidos/actualizar - Modifica un pedido existente",
            "DELETE /api/v1/pedidos/eliminar - Elimina un pedido"
            

        );
    return ResponseEntity.ok(metodos);
    }

    //Listar todos los pedidos
    @GetMapping("/listar")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    //Ingresa un pedido nuevo se completa el totalPedido y no hay que poner id en el body
    @PostMapping("/ingresar")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        // Si el pedido trae un idPedido, verificar si ya existe
        if (pedido.getIdPedido() != null) {
            Pedido existente = pedidoService.buscarPedido(pedido.getIdPedido());
            if (existente != null) {
                // Ya existe un pedido con ese id, no se permite modificar
                return ResponseEntity.status(409).build(); // 409 Conflict
            }
        }
        // Calcular el total antes de guardar
        Double total = pedidoService.calcularTotalPedido(pedido);
        pedido.setTotalPedido(total);
        Pedido nuevoPedido = pedidoService.guardarPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    //Modificar un pedido ya existente
    @PutMapping("/actualizar/{idPedido}")
    public ResponseEntity<Pedido> modificarPedido(@PathVariable Integer idPedido, @RequestBody Pedido pedido) {
        Pedido pedidoExistente = pedidoService.buscarPedido(idPedido);
        if (pedidoExistente != null) {
            // Solo se actualiza el estado
            pedidoExistente.setEstadoPedido(pedido.getEstadoPedido());
            Pedido pedidoActualizado = pedidoService.guardarPedido(pedidoExistente);
            return ResponseEntity.ok(pedidoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Eliminar un pedido
    @DeleteMapping("/eliminar/{idPedido}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer idPedido) {
        Pedido pedidoExistente = pedidoService.buscarPedido(idPedido);
        if (pedidoExistente != null) {
            pedidoService.eliminarPedido(idPedido);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar un pedido por ID de pedido
    @GetMapping("/buscar/{idPedido}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Integer idPedido) {
        Pedido pedido = pedidoService.buscarPedido(idPedido);
        if (pedido == null) {
            System.out.println("Pedido no encontrado");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pedido);
    }

    //Buscar pedidos por ID de tienda
    @GetMapping("/buscarPorTienda/{idTienda}")
    public ResponseEntity<List<Pedido>> buscarPedidosPorTienda(@PathVariable Integer idTienda) {
        List<Pedido> pedidos = pedidoService.buscarPedidosPorTienda(idTienda);
        if (!pedidos.isEmpty()) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar pedidos por nombre de cliente
    @GetMapping("/buscarPorCliente/{nombreCliente}")
    public ResponseEntity<List<Pedido>> buscarPedidosPorCliente(@PathVariable String nombreCliente) {
        List<Pedido> pedidos = pedidoService.buscarPedidosPorCliente(nombreCliente);
        if (!pedidos.isEmpty()) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }   

    //Buscar pedidos por estado de pedido
    @GetMapping("/buscarPorEstado/{estadoPedido}")
    public ResponseEntity<List<Pedido>> buscarPedidosPorEstado(@PathVariable String estadoPedido) {
        List<Pedido> pedidos = pedidoService.buscarPedidosPorEstado(estadoPedido);
        if (!pedidos.isEmpty()) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar pedidos por fecha de pedido
    @GetMapping("/buscarPorFecha/{fechaPedido}")
    public ResponseEntity<List<Pedido>> buscarPedidosPorFecha(@PathVariable String fechaPedido) {
        List<Pedido> pedidos = pedidoService.buscarPedidosPorFecha(fechaPedido);
        if (!pedidos.isEmpty()) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Buscar pedidos por rango de precios
    @GetMapping("/buscarPorRangoPrecios/{precioMin}/{precioMax}")
    public ResponseEntity<List<Pedido>> buscarPedidosPorRangoPrecios(@PathVariable Double precioMin, @PathVariable Double precioMax) {
        List<Pedido> pedidos = pedidoService.buscarPedidosPorRangoPrecios(precioMin, precioMax);
        if (!pedidos.isEmpty()) {
            return ResponseEntity.ok(pedidos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}