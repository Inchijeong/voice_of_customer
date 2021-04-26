package com.voc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.Id;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.voc.api.dto.PenaltyDTO;
import com.voc.api.dto.ReparationDTO;
import com.voc.api.dto.VocDTO;
import com.voc.models.Driver;
import com.voc.models.Voc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("API 통합 테스트")
public class VocApiTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext ctx;
	
	@BeforeEach
	void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
				.addFilter(new CharacterEncodingFilter("UTF-8", true))
				.build();
	}
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	@DisplayName("1. VOC 목록 조회")
	public void _01_findAllVocApiTest() throws Exception {
		
		ResultActions result = mockMvc.perform(
				get("/api/v1/voc")
		);
		result.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("2. 배상 목록 조회")
	public void _02_findAllReparationApiTest() throws Exception {
		
		ResultActions result = mockMvc.perform(
				get("/api/v1/reparations")
		);
		result.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("3. VOC 등록")
	public void _registerVocApiTest() throws Exception {
		
		Driver driver = Driver.builder()
			.driverId(1l)
			.build();
		
		VocDTO vocDTO = new VocDTO();
		vocDTO.setParty("기사");
		vocDTO.setManagerName("매니저");
		vocDTO.setClaimYn(true);
		vocDTO.setCompensationRequestYn(true);
		vocDTO.setDetails("상세 내용");
//		vocDTO.setDriver(driver);
		
		String content = objectMapper.writeValueAsString(vocDTO);
		
		ResultActions result = mockMvc.perform(
				post("/api/v1/voc")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
		);
		result.andDo(print())
			.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("4. 패널티 등록")
	public void _registerPenaltyApiTest() throws Exception {
		
		PenaltyDTO penaltyDTO = new PenaltyDTO();
		penaltyDTO.setAmount(10000l);
		penaltyDTO.setAcceptYn(false);
		penaltyDTO.setObjectionYn(false);
		penaltyDTO.setObjectionDetails("내용");
		
		String content = objectMapper.writeValueAsString(penaltyDTO);
		
		ResultActions result = mockMvc.perform(
				post("/api/v1/voc/1/penalties")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				);
		result.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("5. 배송기사의 패널티 확인 여부 등록")
	public void _updatePenaltyApiTest() throws Exception {
		
		PenaltyDTO penaltyDTO = new PenaltyDTO();
		penaltyDTO.setAcceptYn(true);
		penaltyDTO.setObjectionYn(true);
		penaltyDTO.setObjectionDetails("내용");
		
		String content = objectMapper.writeValueAsString(penaltyDTO);
		
		ResultActions result = mockMvc.perform(
				put("/api/v1/voc/1/panelties")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				);
		result.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("6. 배상 등록")
	public void _registerReparationApiTest() throws Exception {
		
		Voc voc = Voc.builder()
			.vocId(1l)
			.build();
		
		ReparationDTO reparationDTO = new ReparationDTO();
		reparationDTO.setAmount(10000l);
		reparationDTO.setDetails("내용");		
//		reparationDTO.setVoc(voc);
		
		String content = objectMapper.writeValueAsString(reparationDTO);
		
		ResultActions result = mockMvc.perform(
				post("/api/v1/voc/1/reparations")
					.content(content)
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)
		);
		result.andDo(print())
			.andExpect(status().isOk());
	}
}
