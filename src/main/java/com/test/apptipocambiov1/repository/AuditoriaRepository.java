package com.test.apptipocambiov1.repository;

import com.test.apptipocambiov1.entity.AuditoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<AuditoriaEntity,Long> {


}
