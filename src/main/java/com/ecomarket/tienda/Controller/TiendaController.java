package com.ecomarket.tienda.Controller;

import java.util.List;

import com.ecomarket.tienda.Model.Pedido;
import com.ecomarket.tienda.Model.Tienda;
import com.ecomarket.tienda.Model.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecomarket.tienda.Service.TiendaService;

@RestController
@RequestMapping("/api/v1/tienda")
public class TiendaController {

    @Autowired
    TiendaService tiendaService;

    @GetMapping
    public ResponseEntity<List<String>> mostrarMetodos() {
        List<String> metodos = List.of(
                "aca se supone que van los metodos pero no tengo ninguno XD");

        return ResponseEntity.ok(metodos);
    }

    // Mostrar todas las tiendas
    @GetMapping("/mostrarTiendas")
    public ResponseEntity<?> mostrarTiendas() {
        List<Tienda> tiendas = tiendaService.listarTiendas();
        if (tiendas.isEmpty()) {
            return ResponseEntity.badRequest().body("No hay tiendas agregadas");
        }

        return ResponseEntity.ok(tiendas);
    }

    // buscar por id
    @GetMapping("/buscarId/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        if (id < 0 || id == null) {
            return ResponseEntity.badRequest().body("Ingresa un id valido para realizar la busqueda");
        }
        Tienda tienda = tiendaService.buscarTiendaId(id);

        return ResponseEntity.ok(tienda);
    }

    // buscar por nombre
    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<?> buscarNombre(@PathVariable String nombre) {
        if (nombre.isBlank()) {
            return ResponseEntity.badRequest().body("Tienes que ingresar un nombre para realizar la busqueda");
        }

        List<Tienda> tiendaEncontradas = tiendaService.buscarNombreTienda(nombre);

        if (tiendaEncontradas.isEmpty()) {
            return ResponseEntity.badRequest().body("No se han encontrado tiendas que coincidan con el nombre");
        }
        return ResponseEntity.ok(tiendaEncontradas);
    }

    // buscar por direccion
    @GetMapping("/buscarDireccion/{direccion}")
    public ResponseEntity<?> buscarDireccion(@PathVariable String direccion) {
        if (direccion.isBlank()) {
            return ResponseEntity.badRequest().body("Tienes que ingresar una direccion para realizar la busqueda");
        }

        List<Tienda> tiendaEncontradas = tiendaService.buscarDireccionTienda(direccion);

        if (tiendaEncontradas.isEmpty()) {
            return ResponseEntity.badRequest().body("No se han encontrado tiendas que coincidan con esa direccion");
        }
        return ResponseEntity.ok(tiendaEncontradas);
    }

    // ver pedidos de tienda por su id
    @GetMapping("/verPedidos/{id}")
    public ResponseEntity<?> verPedidos(@PathVariable Integer id) {
        List<Pedido> pedidos = tiendaService.verPedidos(id);

        if (pedidos.isEmpty()) {
            return ResponseEntity.badRequest().body("Esta tienda no tiene ningun pedido");
        }

        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/verReportes/{id}")
    public ResponseEntity<?> verReportes(@PathVariable Integer id) {
        List<Reporte> reportes = tiendaService.verReportes(id);

        if (reportes.isEmpty()) {
            return ResponseEntity.badRequest().body("Esta tienda no tiene ningun reporte");
        }

        return ResponseEntity.ok(reportes);
    }
}
