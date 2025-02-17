package uk.co.imperatives.exercise.model;

public record FilmRecommendation(
        Long id,
        String title,
        String description,
        String category,
        String rating,
        Integer length
) {}
