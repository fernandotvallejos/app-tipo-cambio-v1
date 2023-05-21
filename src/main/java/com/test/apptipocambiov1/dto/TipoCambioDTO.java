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
public class TipoCambioDTO implements Serializable {

    private long id;
    private String monedaOrigen;
    private String monedaDestino;
    private Double valorTipoCambio;
    private String fechaAplica;
    private Boolean esUltimoTipoCambio;

}
