package com.voc.api.v1;

import static com.voc.api.dto.ApiResult.succeed;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voc.api.dto.ApiResult;
import com.voc.api.dto.PenaltyDTO;
import com.voc.api.dto.ReparationDTO;
import com.voc.api.dto.VocDTO;
import com.voc.models.Reparation;
import com.voc.models.Voc;
import com.voc.services.PenaltyService;
import com.voc.services.ReparationService;
import com.voc.services.VocService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VocApi {

	final private VocService vocService;
	final private ReparationService reparationService;
	final private PenaltyService penaltyService;	
	
	@GetMapping("/voc")
	public ApiResult<List<Voc>> getVocList(){
		return succeed(vocService.getVocList());
	}
	
	@PostMapping("/voc")
	public ApiResult<Long> registerVoc(@RequestBody VocDTO vocDTO){
		return succeed(vocService.registerVoc(vocDTO));
	}
	
	@PostMapping("/voc/{id}/penalties")
	public ApiResult<Long> registerPenalty(
			@PathVariable("id") Long vocId,
			@RequestBody PenaltyDTO penaltyDTO){
		return succeed(penaltyService.registerPenalty(vocId, penaltyDTO));
	}
	
	@PutMapping("/voc/{id}/penalties")
	public ApiResult<Long> updatePenalty(
			@PathVariable("id") Long vocId,
			@RequestBody PenaltyDTO penaltyDTO){
		return succeed(penaltyService.updatePenalty(vocId, penaltyDTO));
	}
	
	@GetMapping("/reparations")
	public ApiResult<List<Reparation>> getReparationList(){
		return succeed(reparationService.getReparationList());
	}
	
	@PostMapping("/voc/{id}/reparations")
	public ApiResult<Long> registerReparation(
			@PathVariable("id") Long vocId,
			@RequestBody ReparationDTO reparationDTO){
		return succeed(reparationService.registerReparation(vocId, reparationDTO));
	}
	
	
	
}
