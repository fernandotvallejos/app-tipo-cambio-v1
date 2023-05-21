package com.test.apptipocambiov1.service.impl;

import com.test.apptipocambiov1.dto.LogCambioDTO;
import com.test.apptipocambiov1.entity.LogCambioEntity;
import com.test.apptipocambiov1.entity.TipoCambioEntity;
import com.test.apptipocambiov1.mapper.LogCambioMapper;
import com.test.apptipocambiov1.repository.LogCambioRepository;
import com.test.apptipocambiov1.repository.TipoCambioRepository;
import com.test.apptipocambiov1.service.LogCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogCambioServiceImpl implements LogCambioService {

    @Autowired
    LogCambioRepository logCambioRepository;

    @Autowired
    TipoCambioRepository tipoCambioRepository;

    @Override
    public LogCambioDTO ejecutarCambio(LogCambioDTO logCambioDTO) {
        Optional<TipoCambioEntity> tipoCambioEntity = tipoCambioRepository.findById(logCambioDTO.getIdTipoCambio());
        logCambioDTO.setMontoFinal(logCambioDTO.getMontoInicial()*tipoCambioEntity.get().getValorTipoCambio());
        LogCambioEntity logCambioEntity = LogCambioMapper.dtoToEntity(logCambioDTO);
        logCambioEntity.setTipoCambio(tipoCambioEntity.get());
        LogCambioEntity logCambioEntityResponse = logCambioRepository.save(logCambioEntity);
        return LogCambioMapper.entityToDTO(logCambioEntityResponse);
    }

    @Override
    public List<LogCambioDTO> findAll() {
        return LogCambioMapper.toDTOList(logCambioRepository.findAll());
    }

    @Override
    public List<LogCambioDTO> findWithFilter(LogCambioDTO logCambioDTO) {
        return null;
    }
}
