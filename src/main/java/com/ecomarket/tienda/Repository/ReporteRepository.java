package com.ecomarket.tienda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecomarket.tienda.Model.Reporte;

@Repository

public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar reportes por tienda o empleado
    
    
    @Query("SELECT r FROM Reporte r WHERE LOWER(r.nombreEmpleado) LIKE LOWER(CONCAT('%',:nombreEmpleado,'%'))")
    List<Reporte> findByNombreEmpleado(String nombreEmpleado);
    
    @Query("SELECT r FROM Reporte r WHERE LOWER(r.descripcionReporte) LIKE LOWER(CONCAT('%',:descripcionReporte,'%'))")
    List<Reporte> findByDescripcionReporte(String descripcionReporte);

    @Query ("SELECT r FROM Reporte r WHERE LOWER(r.fechaReporte) LIKE LOWER(CONCAT('%',:fechaReporte,'%'))")
    List<Reporte> findByFechaReporte(String fechaReporte);

     
    Reporte findByIdReporte (Integer idReporte);

    


}
