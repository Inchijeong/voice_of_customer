package com.voc.api.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.voc.models.Penalty;
import com.voc.models.Reparation;
import com.voc.models.Voc;
import com.voc.type.PartyType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ReparationDTO {
	
	private Long reparationId;
	private Long amount;
	private String details;
	private Voc voc;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
	public ReparationDTO(Reparation entity) {
		this.reparationId = entity.getReparationId();
		this.amount = entity.getAmount();
		this.details = entity.getDetails();
		this.voc = entity.getVoc();
		this.createdDate = entity.getCreatedDate();
		this.modifiedDate = entity.getModifiedDate();
	}
	
	public Reparation toEntity() {
		return Reparation.builder()
				.reparationId(this.reparationId)
				.amount(this.amount)
				.details(this.details)
				.voc(this.voc)
				.build();
	}
}
