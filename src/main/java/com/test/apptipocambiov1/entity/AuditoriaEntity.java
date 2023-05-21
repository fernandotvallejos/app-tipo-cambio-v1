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
import javax.persistence.Table;
import java.util.Date;

@Entity(name="AuditoriaEntity")
@Table(name="auditoria")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditoriaEntity {

    @Id
    @Column(name="id_auditoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="usuario")
    private String usuario;

    @Column(name="tabla_accion")
    private String tablaAccion;

    @Column(name="accion")
    private String accion;

    @Column(name="fecha_accion")
    private Date fechaAccion;

    @Column(name="json_objeto_anterior")
    private String jsonObjetoAnterior;

    @Column(name="json_objeto_nuevo")
    private String jsonObjectoNuevo;

}
