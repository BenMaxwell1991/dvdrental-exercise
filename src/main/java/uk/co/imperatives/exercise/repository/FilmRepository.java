package uk.co.imperatives.exercise.repository;

import uk.co.imperatives.exercise.model.FilmRecommendation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FilmRepository {

    private final JdbcTemplate jdbcTemplate;

    public FilmRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FilmRecommendation> getRecommendations(Long customerId) {
        String sql = """
            SELECT f.film_id AS id, f.title, f.description, c.name AS category, f.rating, f.length
            FROM film f
            JOIN film_category fc ON f.film_id = fc.film_id
            JOIN category c ON fc.category_id = c.category_id
            WHERE f.film_id NOT IN (
                SELECT i.film_id
                FROM rental r
                JOIN inventory i ON r.inventory_id = i.inventory_id
                WHERE r.customer_id = ?
            )
            GROUP BY f.film_id, f.title, f.description, c.name, f.rating, f.length, fc.category_id
            ORDER BY 
                (SELECT COUNT(*)
                 FROM rental r
                 JOIN inventory i ON r.inventory_id = i.inventory_id
                 JOIN film_category fc2 ON i.film_id = fc2.film_id
                 WHERE r.customer_id = ? AND fc2.category_id = fc.category_id) DESC,
                (SELECT COUNT(*)
                 FROM rental r2
                 JOIN inventory i2 ON r2.inventory_id = i2.inventory_id
                 WHERE i2.film_id = f.film_id) DESC,
                f.title ASC
            LIMIT 10;
            """;

        return jdbcTemplate.query(sql, new Object[]{customerId, customerId}, (rs, rowNum) ->
                new FilmRecommendation(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getString("rating"),
                        rs.getInt("length")
                )
        );
    }
}
