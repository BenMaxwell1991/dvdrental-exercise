package uk.co.imperatives.exercise.controller;

import uk.co.imperatives.exercise.model.FilmRecommendation;
import uk.co.imperatives.exercise.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<FilmRecommendation>> getRecommendations(@PathVariable Long customerId) {
        List<FilmRecommendation> recommendations = recommendationService.getRecommendations(customerId);
        return ResponseEntity.ok(recommendations);
    }
}
