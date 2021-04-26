package com.voc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voc.api.dto.ReparationDTO;
import com.voc.models.Reparation;
import com.voc.models.Voc;
import com.voc.repositories.ReparationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReparationService{

	final private VocService vocService;
	final private ReparationRepository reperationRepository;
	
	public List<Reparation> getReparationList(){
		return reperationRepository.findAll();
	}
	
	public Long registerReparation(Long vocId, ReparationDTO reparationDTO) {
		Voc voc = Voc.builder()
			.vocId(vocId)
			.build();
		reparationDTO.setVoc(voc);
		
		Reparation reparation = reperationRepository.save(reparationDTO.toEntity());
		
		vocService.updateVocReparationId(vocId, reparation);
		
		return reparation.getReparationId();
	}
}
