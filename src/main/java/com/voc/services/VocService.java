package com.voc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.voc.api.dto.VocDTO;
import com.voc.models.Penalty;
import com.voc.models.Reparation;
import com.voc.models.Voc;
import com.voc.repositories.VocRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocService{

	final private VocRepository vocRepository;
	
	public List<Voc> getVocList(){
		return vocRepository.findAll();
	}
	
	public Long registerVoc(VocDTO vocDTO) {
		Voc voc = vocRepository.save(vocDTO.toEntity());
		return voc.getVocId();
	}
	
	public Long updateVocPenaltyId(Long vocId, Penalty penalty) {
		Optional<Voc> vocWrapper = vocRepository.findById(vocId);
		vocWrapper.ifPresent(voc -> {
			VocDTO vocDTO = new VocDTO(voc);
			vocDTO.setPenalty(penalty);
			vocRepository.save(vocDTO.toEntity());
		});
		return vocId;
	}
	
	public Long updateVocReparationId(Long vocId, Reparation reparation) {
		Optional<Voc> vocWrapper = vocRepository.findById(vocId);
		vocWrapper.ifPresent(voc -> {
			VocDTO vocDTO = new VocDTO(voc);
			vocDTO.setReparation(reparation);
			vocRepository.save(vocDTO.toEntity());
		});
		return vocId;
	}
}
