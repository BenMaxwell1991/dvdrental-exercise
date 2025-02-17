package uk.co.imperatives.exercise.service;

import uk.co.imperatives.exercise.model.FilmRecommendation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RecommendationServiceTest {

	@Autowired
	private RecommendationService service;

	@Test
	void testRecommendations() {
		List<FilmRecommendation> recommendations = service.getRecommendations(1L);
		assertThat(recommendations).hasSize(10);
		assertThat(recommendations).allSatisfy(f -> assertThat(f.title()).isNotEmpty());
	}
}
