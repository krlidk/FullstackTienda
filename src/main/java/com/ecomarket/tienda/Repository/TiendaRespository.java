package com.ecomarket.tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecomarket.tienda.Model.Tienda;
import java.util.List;

@Repository
public interface TiendaRespository extends JpaRepository<Tienda, Integer> {

    // buscar tienda por id
    Tienda findByIdTienda(Integer idTienda);

    // buscar tienda por nombre
    @Query("SELECT t FROM Tienda t WHERE LOWER(t.nombreTienda) LIKE LOWER(CONCAT('%',:nombreTienda,'%')) ")
    List<Tienda> findByNombreTienda(String nombreTienda);

    // buscar por direccion
    @Query("SELECT t FROM Tienda t WHERE LOWER(t.direccionTienda) LIKE LOWER(CONCAT('%',:direccionTienda,'%'))")
    List<Tienda> findBydireccionTienda(String direccionTienda);

}
