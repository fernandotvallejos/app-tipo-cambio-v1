package com.test.apptipocambiov1.service;

import com.test.apptipocambiov1.dto.TipoCambioDTO;

import java.util.List;

public interface TipoCambioService {

    List<TipoCambioDTO> findAll();
    List<TipoCambioDTO> finWithFilter(String monedaOrigen, String monedaDestino, String fecha);
    TipoCambioDTO save(TipoCambioDTO tipoCambioDTO, String user);
    void update(TipoCambioDTO tipoCambioDTO, String user);


}
