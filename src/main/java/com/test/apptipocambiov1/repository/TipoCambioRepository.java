package com.test.apptipocambiov1.repository;

import com.test.apptipocambiov1.entity.TipoCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambioEntity,Long> {

    @Query("Select tc  from TipoCambioEntity tc where tc.fechaAplica = :fecha and tc.monedaOrigen = :origen and tc.monedaDestino = :destino and tc.ultimoTipoCambio = true")
    TipoCambioEntity countByDate(@Param("fecha") Date fecha, @Param("origen") String monedaOrigen, @Param("destino") String monedaDestino);

    @Query("select tc from TipoCambioEntity tc where ( :origen is null or tc.monedaOrigen = :origen ) and ( :destino is null or tc.monedaDestino = :destino ) and ( :fecha is null or tc.fechaAplica = :fecha ) ")
    List<TipoCambioEntity> findWithFilter(@Param("origen") String monedaOrigin, @Param("destino") String monedaDestino, @Param("fecha")Date fecha);

    @Transactional
    @Modifying
    @Query("update TipoCambioEntity tc set tc.ultimoTipoCambio = :status where tc.id = :id ")
    void updateStatus(@Param("id") long id, @Param("status")Boolean status);

    @Transactional
    @Modifying
    @Query("update TipoCambioEntity tc set tc.monedaOrigen = :origen, tc.monedaDestino = :destino, tc.fechaAplica = :fecha, tc.valorTipoCambio = :tipoCambio where tc.id = :id ")
    void update(@Param("id") long id, @Param("origen")String monedaOrigen, @Param("destino")String monedaDestino, @Param("fecha")Date fecha, @Param("tipoCambio")Double tipoCambio);



}
