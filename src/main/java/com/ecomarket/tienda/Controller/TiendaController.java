package com.ecomarket.tienda.Controller;

import java.util.List;
import java.util.Map;

import com.ecomarket.tienda.Model.Pedido;
import com.ecomarket.tienda.Model.Tienda;
import com.ecomarket.tienda.Model.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecomarket.tienda.Service.TiendaService;

@RestController
@RequestMapping("/api/v1/tienda")
public class TiendaController {

    @Autowired
    TiendaService tiendaService;

    @GetMapping
    public ResponseEntity<List<String>> mostrarMetodos() {
        List<String> metodos = List.of(
                "GET    http://localhost:8080/api/v1/tienda/mostrarTiendas",
                "GET    http://localhost:8080/api/v1/tienda/buscarId/{id}",
                "GET    http://localhost:8080/api/v1/tienda/buscarNombre/{nombre}",
                "GET    http://localhost:8080/api/v1/tienda/buscarDireccion/{direccion}",
                "GET    http://localhost:8080/api/v1/tienda/verPedidos/{id}",
                "GET    http://localhost:8080/api/v1/tienda/verReportes/{id}",
                "DELETE http://localhost:8080/api/v1/tienda/borrar/{id}"
                );

        return ResponseEntity.ok(metodos);
    }

    //Guardar tienda
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarTienda(@RequestBody Tienda tienda){
        Tienda tiendaGuardada = tiendaService.guardarTienda(tienda);
        return ResponseEntity.ok(tiendaGuardada);

    }   
    //Actualizar informacion de tienda
    @PutMapping("modificar/{id}")
    public ResponseEntity<?> actualizarTienda(@PathVariable int id,@RequestBody Map<String, Object>dato ){
        Tienda tienda = tiendaService.actualizarTienda(id, dato);
        return ResponseEntity.ok(tienda);
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

    //Eliminar por id
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id){
        tiendaService.Eliminar(id);

        return ResponseEntity.ok().body("producto eliminado");
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
