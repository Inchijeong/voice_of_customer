package com.voc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voc.models.Reparation;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation, Long>{

}
