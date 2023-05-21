package com.test.apptipocambiov1.service;

import com.test.apptipocambiov1.dto.LogCambioDTO;

import java.util.List;

public interface LogCambioService {

    LogCambioDTO ejecutarCambio(LogCambioDTO logCambioDTO);
    List<LogCambioDTO> findAll();
    List<LogCambioDTO> findWithFilter(LogCambioDTO logCambioDTO);


}
