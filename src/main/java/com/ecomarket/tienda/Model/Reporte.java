package com.ecomarket.tienda.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reporte")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporte;

    @Column(nullable = false)
    private String nombreReporte;

    @Column(nullable = false)
    private String nombreEmpleado;

    @Column(nullable = false)
    private String descripcionReporte;

    @Column(nullable = false)
    private String fechaReporte;

    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "idTienda", nullable = false)
    private Tienda tienda;
    // Relación con la entidad Tienda
}
