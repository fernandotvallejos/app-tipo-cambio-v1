package com.test.apptipocambiov1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity(name="TipoCambioEntity")
@Table(name="tipo_cambio")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambioEntity {
    @Id
    @Column(name="id_tipo_cambio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="moneda_origen")
    private String monedaOrigen;

    @Column(name="moneda_destino")
    private String monedaDestino;

    @Column(name="valor_tipo_cambio")
    private Double valorTipoCambio;

    @Column(name="fecha_aplica")
    private Date fechaAplica;

    @Column(name="ultimo_tipo_cambio")
    private Boolean ultimoTipoCambio;

}
