package com.ecomarket.tienda.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.tienda.Model.Reporte;

import com.ecomarket.tienda.Repository.ReporteRepository;
import com.ecomarket.tienda.Service.ReporteService;



import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;








@RestController
@RequestMapping("/api/reporte")
public class ReporteController {

    
    
    @Autowired
    private ReporteService reporteService;
    
    @Autowired
    private ReporteRepository reporteRepository;

    @GetMapping("/metodos")
public ResponseEntity<List<String>> metodosdisponibles() {
    List<String> metodos = List.of(
        "GET /api/reporte/listar - listar todos los reportes",
        "POST /api/reporte/guardar - guardar un reporte",
        "DELETE /api/reporte/eliminar - eliminar un reporte por id",
        "GET /api/reporte/verporid - buscar un reporte por id",
        "PUT /api/reporte/actualizar - actualizar un reporte por id",
        "GET /api/reporte/buscarempleado - buscar por nombre del empleado",
        "GET /api/reporte/buscarfecha - buscar por fechar del reporte"
    );

    return ResponseEntity.ok(metodos);
}





    ////ok 
    /// listar todos los reporte
    @GetMapping("/listar")
    public List<Reporte> verReporte(){
        return reporteRepository.findAll();

    }
    //// ok 
    /// ver por id 
    @GetMapping("/verporid/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable Integer id) {
      Reporte reporte = reporteRepository.findById(id).orElse(null);
    if (reporte==null) {
        return ResponseEntity.notFound().build();
    } 
      return ResponseEntity.ok(reporte);
    }

    

    //// ok
    /// eliminar reporte
    @DeleteMapping("eliminar/{idReporte}")
    public ResponseEntity <Void> eliminarReporte(@PathVariable Integer idReporte){
      if(reporteRepository.existsById(idReporte)){
        reporteRepository.deleteById(idReporte);
        return ResponseEntity.noContent().build(); // 204 no contenido

      }else{
        return ResponseEntity.notFound().build(); // 404 nor found
    }
      
    }
    
      ///ok 
    //// buscar por nombre empleado
    @GetMapping("/buscarempleado/{nombreEmpleado}")
    public ResponseEntity<?> buscarporEmpleado(@PathVariable String nombreEmpleado){
      if(nombreEmpleado.isBlank()){ //// devuelve  i sun valor esta en blanco 
        return ResponseEntity.badRequest().body("ingresa un nombre valido");
      }
      List<Reporte> reportes = reporteRepository.findByNombreEmpleado(nombreEmpleado);
      if(reportes.isEmpty()){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NO SE HA ENCONTRADO REPOTES QUE CONCIDAD CON EL NOMBRE");

      }
      return ResponseEntity.ok(reportes);

    }
    /// ok 
    /// buscar por fechareporte
    @GetMapping("/buscarfecha/{fechaReporte}")
    public ResponseEntity<List<Reporte>> buscarPorfecha(@PathVariable String fechaReporte){
      List<Reporte> reportes = reporteService.buscarPorfecha(fechaReporte);
      if(!reportes.isEmpty()){
        return ResponseEntity.ok(reportes);
        
      }else{
        
        return ResponseEntity.noContent().build();
      } 
    }
  
      ///// ok 
    @PutMapping("actualizar/{idReporte}")
    public ResponseEntity<Reporte> actualizar (@PathVariable("idReporte")Integer idReporte, @RequestBody Reporte reporte){
      try{
        
        Reporte repor = reporteService.buscarPorId(idReporte);
        if(repor == null){
          return ResponseEntity.notFound().build();
        }
        repor.setNombreReporte(reporte.getNombreReporte());
        repor.setNombreEmpleado(reporte.getNombreEmpleado());
        repor.setDescripcionReporte(reporte.getDescripcionReporte());
        repor.setFechaReporte(reporte.getFechaReporte());
        reporteRepository.save(repor);
        return ResponseEntity.ok(repor);
      }catch(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }

    }
    // ok
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Reporte reporte) {
    try {
        Reporte saved = reporteRepository.save(reporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al guardar el reporte: " + e.getMessage());
    
    }


  



}

}