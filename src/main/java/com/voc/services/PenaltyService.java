package com.voc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voc.api.dto.PenaltyDTO;
import com.voc.models.Penalty;
import com.voc.repositories.PenaltyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PenaltyService{

	final private VocService vocService;
	final private PenaltyRepository penaltyRepository;

	@Transactional
	public Long registerPenalty(Long vocId, PenaltyDTO penaltyDTO) {
		Penalty penalty = penaltyRepository.save(penaltyDTO.toEntity());
		
		vocService.updateVocPenaltyId(vocId, penalty);
		
		return penalty.getPenaltyId();
	}
	
	public Long updatePenalty(Long vocId, PenaltyDTO penaltyDTO) {
		Penalty penalty = penaltyRepository.save(penaltyDTO.toEntity());
		
		return penalty.getPenaltyId();
	}
}
