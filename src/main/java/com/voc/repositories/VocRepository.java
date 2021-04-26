package com.voc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voc.models.Voc;

@Repository
public interface VocRepository extends JpaRepository<Voc, Long>{

}
