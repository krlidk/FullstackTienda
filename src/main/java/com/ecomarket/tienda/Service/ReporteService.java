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

    // ver lista reportes
    public List<Reporte> obtenerTodosLosReportes() {
        return reporteRepository.findAll();
    }

    // crear reportes
    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    // eliminar reportes por id
    public void eliminarReporte(Integer id) {
        reporteRepository.deleteById(id);
    }
    
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

    // buscar por nombre empleado
    public List<Reporte> buscarporempleado(String nombreEmpleado) {
        return reporteRepository.findByNombreEmpleado(nombreEmpleado);
    }

    // buscar por id 
    public Reporte buscarPorId(Integer idReporte) {
        return reporteRepository.findByIdReporte(idReporte);
    }

    //buscar por fecha de reportes
    public List<Reporte> buscarPorfecha ( String fechaReporte){
        return reporteRepository.findByFechaReporte(fechaReporte);
    } 

}
