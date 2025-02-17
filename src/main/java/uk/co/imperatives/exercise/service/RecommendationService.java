package uk.co.imperatives.exercise.service;

import uk.co.imperatives.exercise.model.FilmRecommendation;
import uk.co.imperatives.exercise.repository.FilmRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationService {

    private final FilmRepository filmRepository;

    public RecommendationService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<FilmRecommendation> getRecommendations(Long customerId) {
        return filmRepository.getRecommendations(customerId);
    }
}
