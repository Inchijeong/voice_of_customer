package com.voc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voc.models.Penalty;

@Repository
public interface PenaltyRepository extends JpaRepository<Penalty, Long>{

}
