package com.ecomarket.tienda.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.tienda.Model.Reporte;
import com.ecomarket.tienda.Repository.ReporteRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ReporteService {
    
    @Autowired
    private ReporteRepository reporteRepository;
    // ver reportes listar --
    // guardar reportes
    // eliminar reportes--
    // actualizar reportes (solo se puede actulizar el tipo de reporte y su descripcion)--
    // buscar por empleado que  hizo el reporte
    // buscar por id reportes --
    // buscar por fecha de reporte--

    // ok 
    // ver lista reportes
    public List<Reporte> obtenerTodosLosReportes() {
        return reporteRepository.findAll();
    }
    //espera
    /// crear reportes
    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }
    ////ok
    // eliminar reportes por id
    public void eliminarReporte(Integer id) {
        reporteRepository.deleteById(id);
    }
    /// ok
    
    // actualizar reportes
    public Reporte actualizarReporte(Reporte reporte) {
        Reporte reporteExistente = reporteRepository.findById(reporte.getIdReporte())
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado"));

            reporteExistente.setNombreReporte(reporte.getNombreReporte());
            reporteExistente.setDescripcionReporte(reporte.getDescripcionReporte());
            reporteExistente.setNombreEmpleado(reporte.getNombreEmpleado());
            reporteExistente.setFechaReporte(reporte.getFechaReporte());

            return reporteRepository.save(reporteExistente);
    }
        /// ok
    // buscar por nombre empleado
    public List<Reporte> buscarporempleado(String nombreEmpleado) {
        return reporteRepository.findByNombreEmpleado(nombreEmpleado);
    }
    //// ok
    // buscar por id 
    public Reporte buscarPorId(Integer idReporte) {
        return reporteRepository.findByIdReporte(idReporte);
    }
    //// ok
    //buscar por fecha de reportes
    public List<Reporte> buscarPorfecha ( String fechaReporte){
        return reporteRepository.findByFechaReporte(fechaReporte);
    } 

    

    


}
