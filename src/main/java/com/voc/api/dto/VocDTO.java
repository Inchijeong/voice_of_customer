package com.voc.api.dto;

import java.time.LocalDateTime;

import com.voc.models.Company;
import com.voc.models.Driver;
import com.voc.models.Penalty;
import com.voc.models.Reparation;
import com.voc.models.Voc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class VocDTO {
	
	private Long vocId;
    private String party;
    private String managerName;
    private String details;
    private Boolean claimYn;
    private Boolean compensationRequestYn;
    private Company company;
    private Driver driver;
    private Penalty penalty;
    private Reparation reparation;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
	
	public VocDTO(Voc entity) {
		this.vocId = entity.getVocId();
		this.party = entity.getParty();
		this.managerName = entity.getManagerName();
		this.details = entity.getDetails();
		this.claimYn = entity.getClaimYn();
		this.compensationRequestYn = entity.getCompensationRequestYn();
		this.company = entity.getCompany();
		this.driver = entity.getDriver();
		this.penalty = entity.getPenalty();
		this.reparation = entity.getReparation();
		this.createdDate = entity.getCreatedDate();
		this.modifiedDate = entity.getModifiedDate();
	}
	
	public Voc toEntity() {
		return Voc.builder()
				.vocId(this.vocId)
				.party(this.party)
				.managerName(this.managerName)
				.details(this.details)
				.claimYn(this.claimYn)
				.compensationRequestYn(this.compensationRequestYn)
				.company(this.company)
				.driver(this.driver)
				.penalty(this.penalty)
				.reparation(this.reparation)
				.build();
	}
}
