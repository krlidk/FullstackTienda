package com.ecomarket.tienda.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column(nullable = false)
    private String nombreCliente;

    @Column(nullable = false)
    private String fechaPedido;

    @Column(nullable = false)
    private String estadoPedido; // "Pendiente", "Enviado", "Entregado"

    @Column(nullable = true)
    private Double totalPedido;

    @ManyToMany
    @JoinTable(
        name = "pedido_producto",
        joinColumns = @JoinColumn(name = "idPedido"),
        inverseJoinColumns = @JoinColumn(name = "idProducto")
        )
    private List<Producto> productos;
    // Relación con la entidad Producto

    @ManyToOne
    @JoinColumn(name = "idTienda", nullable = false)
    private Tienda tienda;
    // Relación con la entidad Tienda
}
