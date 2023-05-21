package com.test.apptipocambiov1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity(name="LogCambioEntity")
@Table(name="log_cambio")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogCambioEntity {

    @Id
    @Column(name="id_log_cambio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="usuario")
    private String usuario;

    @Column(name="fecha_ejecucion")
    private Date fechaEjecucion;

    @ManyToOne
    @JoinColumn(name="id_tipo_cambio")
    private TipoCambioEntity tipoCambio;

    @Column(name="monto_final")
    private Double montoFinal;

    @Column(name="monto_inicial")
    private Double montoInicial;

}
