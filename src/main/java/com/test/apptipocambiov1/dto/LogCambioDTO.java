package com.test.apptipocambiov1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LogCambioDTO implements Serializable {

    private long id;
    private String usuario;
    private String fechaEjecucion;
    private Long idTipoCambio;
    private TipoCambioDTO tipoCambioDTO;
    private Double montoInicial;
    private Double montoFinal;


}
