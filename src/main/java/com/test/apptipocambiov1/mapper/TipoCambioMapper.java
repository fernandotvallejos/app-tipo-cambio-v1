package com.test.apptipocambiov1.mapper;


import com.test.apptipocambiov1.dto.TipoCambioDTO;
import com.test.apptipocambiov1.entity.TipoCambioEntity;
import com.test.apptipocambiov1.util.FechaUtil;

import java.util.List;
import java.util.stream.Collectors;

public class TipoCambioMapper {

    public static TipoCambioEntity dtoToEntity(TipoCambioDTO dto){
        return TipoCambioEntity.builder()
                .valorTipoCambio(dto.getValorTipoCambio())
                .fechaAplica(FechaUtil.convertStringToDate(dto.getFechaAplica(),"dd/MM/yyyy"))
                .monedaDestino(dto.getMonedaDestino())
                .monedaOrigen(dto.getMonedaOrigen())
                .ultimoTipoCambio(dto.getEsUltimoTipoCambio())
                .build();
    }

    public static TipoCambioDTO entityToDTO(TipoCambioEntity entity){
        return TipoCambioDTO.builder()
                .id(entity.getId())
                .valorTipoCambio(entity.getValorTipoCambio())
                .fechaAplica(FechaUtil.convertDateToString(entity.getFechaAplica(),"dd/MM/yyyy"))
                .monedaDestino(entity.getMonedaDestino())
                .monedaOrigen(entity.getMonedaOrigen())
                .esUltimoTipoCambio(entity.getUltimoTipoCambio())
                .build();
    }

    public static List<TipoCambioDTO> toDTOList(List<TipoCambioEntity> listEntity){
        return listEntity.stream().map(x->entityToDTO(x)).collect(Collectors.toList());
    }

    public static List<TipoCambioEntity> toEntityList(List<TipoCambioDTO> listDTO){
        return listDTO.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }


}
