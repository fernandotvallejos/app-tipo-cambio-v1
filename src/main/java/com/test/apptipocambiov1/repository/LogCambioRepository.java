package com.test.apptipocambiov1.repository;

import com.test.apptipocambiov1.entity.LogCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogCambioRepository extends JpaRepository<LogCambioEntity,Long> {

}
