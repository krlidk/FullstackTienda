package com.ecomarket.tienda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecomarket.tienda.Model.Reporte;

@Repository

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {

    //Buscar un reporte por nombre de empleado
    @Query("SELECT r FROM Reporte r WHERE LOWER(r.nombreEmpleado) LIKE LOWER(CONCAT('%',:nombreEmpleado,'%'))")
    List<Reporte> findByNombreEmpleado(String nombreEmpleado);

    // Buscar un reporte por parte de la descripcion del reporte
    @Query("SELECT r FROM Reporte r WHERE LOWER(r.descripcionReporte) LIKE LOWER(CONCAT('%',:descripcionReporte,'%'))")
    List<Reporte> findByDescripcionReporte(String descripcionReporte);

    // Buscar un reporte por fecha
    @Query("SELECT r FROM Reporte r WHERE LOWER(r.fechaReporte) LIKE LOWER(CONCAT('%',:fechaReporte,'%'))")
    List<Reporte> findByFechaReporte(String fechaReporte);

    // Buscar un reporte por ID
    Reporte findByIdReporte(Integer idReporte);

}
