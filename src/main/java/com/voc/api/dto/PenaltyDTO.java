package com.voc.api.dto;

import java.time.LocalDateTime;

import com.voc.models.Driver;
import com.voc.models.Penalty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class PenaltyDTO {
	
	private Long penaltyId;
	private Long amount;
	private Boolean acceptYn;
	private Boolean objectionYn;
	private String objectionDetails;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
	public PenaltyDTO(Penalty entity) {
		this.penaltyId = entity.getPenaltyId();
		this.amount = entity.getAmount();
		this.acceptYn = entity.getAcceptYn();
		this.objectionYn = entity.getObjectionYn();
		this.objectionDetails = entity.getObjectionDetails();
		this.createdDate = entity.getCreatedDate();
		this.modifiedDate = entity.getModifiedDate();
	}
	
	public Penalty toEntity() {
		return Penalty.builder()
				.penaltyId(this.penaltyId)
				.amount(this.amount)
				.acceptYn(this.acceptYn)
				.objectionYn(this.objectionYn)
				.objectionDetails(this.objectionDetails)
				.build();
	}
}
