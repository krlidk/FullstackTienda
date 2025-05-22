package com.ecomarket.tienda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.tienda.Repository.TiendaRespository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ecomarket.tienda.Model.*;

@Service
public class TiendaService {

    @Autowired
    TiendaRespository tiendaRespository;

    public List<Tienda> listarTiendas() {
        return tiendaRespository.findAll();
    }

    // buscar por id de tienda
    public Tienda buscarTiendaId(Integer id) {
        return tiendaRespository.findByIdTienda(id);
    }

    // buscar por nombre
    public List<Tienda> buscarNombreTienda(String nombre) {
        return tiendaRespository.findByNombreTienda(nombre);
    }

    // buscar por direccion
    public List<Tienda> buscarDireccionTienda(String direccion) {
        return tiendaRespository.findBydireccionTienda(direccion);
    }

    //Eliminar tienda
    public void Eliminar(int id){
        tiendaRespository.deleteById(id);
    }

    // ver pedidos de tienda por su id
    public List<Pedido> verPedidos(Integer id) {
        Tienda tienda = tiendaRespository.findByIdTienda(id);

        if (tienda == null || tienda.getPedidos() == null) {
            return Collections.emptyList();
        }
        List<Pedido> pedidos = tienda.getPedidos();

        return pedidos;
    }

    // ver reportes de tienda por su id
    public List<Reporte> verReportes(Integer id) {
        Tienda tienda = tiendaRespository.findByIdTienda(id);

        if (tienda == null || tienda.getReportes() == null) {
            return Collections.emptyList();
        }
        List<Reporte> reportes = tienda.getReportes();

        return reportes;
    }

    //Actualizar informacion de tienda
    public Tienda actualizarTienda(int id, Map<String, Object> datos){
        
        Optional<Tienda> tiendaOP = tiendaRespository.findById(id);
        Tienda tienda = tiendaOP.orElseThrow(() -> new IllegalArgumentException("Tienda no encontrado"));

        if(datos.containsKey("nombreTienda")){
            tienda.setNombreTienda((String) datos.get("nombreTienda"));
        }

        return tienda;
    }
    public Tienda guardarTienda (Tienda tienda){
        return tiendaRespository.save(tienda);
    }
}
