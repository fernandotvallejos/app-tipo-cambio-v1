package com.test.apptipocambiov1.service.impl;

import com.google.gson.Gson;
import com.test.apptipocambiov1.dto.TipoCambioDTO;
import com.test.apptipocambiov1.entity.AuditoriaEntity;
import com.test.apptipocambiov1.entity.TipoCambioEntity;
import com.test.apptipocambiov1.mapper.TipoCambioMapper;
import com.test.apptipocambiov1.repository.AuditoriaRepository;
import com.test.apptipocambiov1.repository.TipoCambioRepository;
import com.test.apptipocambiov1.service.TipoCambioService;
import com.test.apptipocambiov1.util.FechaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value="tipoCambioService")
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    TipoCambioRepository tipoCambioRepository;
    @Autowired
    AuditoriaRepository auditoriaRepository;

    @Override
    public List<TipoCambioDTO> findAll() {
        return TipoCambioMapper.toDTOList(tipoCambioRepository.findAll());
    }

    @Override
    public List<TipoCambioDTO> finWithFilter(String monedaOrigen, String monedaDestino, String fecha) {
        return TipoCambioMapper.toDTOList(tipoCambioRepository.findWithFilter(monedaOrigen, monedaDestino, FechaUtil.convertStringToDate(fecha,"dd/MM/yyyy")));
    }

    @Override
    public TipoCambioDTO save(TipoCambioDTO tipoCambioDTO, String user) {
        TipoCambioEntity tipoCambioAntiguo = tipoCambioRepository.countByDate( FechaUtil.convertStringToDate(tipoCambioDTO.getFechaAplica(),"dd/MM/yyyy"), tipoCambioDTO.getMonedaOrigen(),tipoCambioDTO.getMonedaDestino() );
        TipoCambioEntity tipoCambioNuevo = null;
        Gson gson = new Gson();
        if(Objects.nonNull(tipoCambioAntiguo)){
            auditoriaRepository.save(
                    AuditoriaEntity.builder()
                            .usuario(user)
                            .fechaAccion(new Date())
                            .accion("U")
                            .tablaAccion("tipo_cambio")
                            .jsonObjetoAnterior(gson.toJson(tipoCambioAntiguo)).build());
            tipoCambioRepository.updateStatus(tipoCambioAntiguo.getId(),false);
        }
        tipoCambioDTO.setEsUltimoTipoCambio(true);
        tipoCambioNuevo = tipoCambioRepository.save(TipoCambioMapper.dtoToEntity(tipoCambioDTO));
        auditoriaRepository.save(
                AuditoriaEntity.builder()
                        .usuario(user)
                        .fechaAccion(new Date())
                        .accion("C")
                        .tablaAccion("tipo_cambio")
                        .jsonObjectoNuevo(gson.toJson(tipoCambioNuevo)).build());
        return TipoCambioMapper.entityToDTO(tipoCambioNuevo);
    }

    @Override
    public void update(TipoCambioDTO tipoCambioDTO, String user) {
        Optional<TipoCambioEntity> tipoCambioAnterior = tipoCambioRepository.findById(tipoCambioDTO.getId());
        Gson gson = new Gson();
        tipoCambioRepository.update(
                tipoCambioDTO.getId(),
                tipoCambioDTO.getMonedaOrigen(),
                tipoCambioDTO.getMonedaDestino(),
                FechaUtil.convertStringToDate(tipoCambioDTO.getFechaAplica(), "dd/MM/yyyy"),
                tipoCambioDTO.getValorTipoCambio());
        auditoriaRepository.save(
                AuditoriaEntity.builder()
                        .usuario(user)
                        .fechaAccion(new Date())
                        .accion("U")
                        .tablaAccion("tipo_cambio")
                        .jsonObjetoAnterior(gson.toJson(tipoCambioAnterior.get()))
                        .jsonObjectoNuevo(gson.toJson(TipoCambioMapper.dtoToEntity(tipoCambioDTO))).build());
    }
}
