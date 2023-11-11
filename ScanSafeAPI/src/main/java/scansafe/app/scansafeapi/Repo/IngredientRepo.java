package scansafe.app.scansafeapi.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import scansafe.app.scansafeapi.Models.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
}
