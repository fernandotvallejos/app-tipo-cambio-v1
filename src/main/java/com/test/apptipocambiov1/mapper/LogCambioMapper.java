package com.test.apptipocambiov1.mapper;

import com.test.apptipocambiov1.dto.LogCambioDTO;
import com.test.apptipocambiov1.entity.LogCambioEntity;
import com.test.apptipocambiov1.util.FechaUtil;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LogCambioMapper {

    public static LogCambioDTO entityToDTO(LogCambioEntity entity){
        return LogCambioDTO.builder()
                .id(entity.getId())
                .fechaEjecucion(FechaUtil.convertDateToString(entity.getFechaEjecucion(),"dd/MM/yyyy hh:mm:ss"))
                .usuario(entity.getUsuario())
                .tipoCambioDTO(TipoCambioMapper.entityToDTO(entity.getTipoCambio()))
                .montoFinal(entity.getMontoFinal())
                .montoInicial(entity.getMontoInicial())
                .idTipoCambio(null)
                .build();
    }

    public static LogCambioEntity dtoToEntity(LogCambioDTO dto){
        return LogCambioEntity.builder()
                .fechaEjecucion(new Date())
                .usuario(dto.getUsuario())
                .montoFinal(dto.getMontoFinal())
                .montoInicial(dto.getMontoInicial())
                .build();
    }

    public static List<LogCambioDTO> toDTOList(List<LogCambioEntity> entity){
        return entity.stream().map(x->entityToDTO(x)).collect(Collectors.toList());
    }



}
