package com.voc;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.voc.models.Voc;
import com.voc.repositories.VocRepository;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VocRepositoryTests {

	
	@Autowired
	private VocRepository vocRepository;
	
	@Test
	public void createVocTest() {
		LongStream.range(0, 10).forEach(i -> {
			
			Voc voc = Voc.builder()
					.build();
			
			vocRepository.save(voc);
		});
	}
}
