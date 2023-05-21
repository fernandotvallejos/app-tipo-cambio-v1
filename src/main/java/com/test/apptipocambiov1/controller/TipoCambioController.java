package com.test.apptipocambiov1.controller;

import java.util.List;

import com.test.apptipocambiov1.dto.LogCambioDTO;
import com.test.apptipocambiov1.dto.TipoCambioDTO;
import com.test.apptipocambiov1.service.LogCambioService;
import com.test.apptipocambiov1.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tipo-cambio")
public class TipoCambioController {

    @Autowired
    TipoCambioService tipoCambioService;
    @Autowired
    LogCambioService logCambioService;

    @GetMapping
    List<TipoCambioDTO> findAll(){
        return tipoCambioService.findAll();
    }

    @PostMapping("/agregar")
    TipoCambioDTO save(@RequestBody TipoCambioDTO tipoCambioDTO){
        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return tipoCambioService.save(tipoCambioDTO, user);
    }

    @PostMapping("/filtrar")
    List<TipoCambioDTO> findWithFilter(@RequestBody TipoCambioDTO tipoCambioDTO){
        return tipoCambioService.finWithFilter(tipoCambioDTO.getMonedaOrigen(),tipoCambioDTO.getMonedaDestino(), tipoCambioDTO.getFechaAplica());
    }

    @PutMapping("/actualizar")
    void actualizar(@RequestBody TipoCambioDTO tipoCambioDTO){
        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        tipoCambioService.update(tipoCambioDTO, user);
    }

    @PostMapping("/ejecutar")
    LogCambioDTO ejecutar(@RequestBody LogCambioDTO logCambioDTO){
        logCambioDTO.setUsuario(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return logCambioService.ejecutarCambio(logCambioDTO);
    }

    @GetMapping("/log/listar")
    List<LogCambioDTO> findAllLog(){
        return logCambioService.findAll();
    }







}
