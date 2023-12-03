package scansafe.app.scansafeapi.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepo ingredientRepo;

    @GetMapping("/")
    public String getPage() {
        return "welcome!";
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<scansafe.app.scansafeapi.Ingredient.IngredientModel> getIngredients() {
        return ingredientRepo.findAll();
    }

    @CrossOrigin
    @PostMapping("/save")
    public String saveIngredient(@RequestBody scansafe.app.scansafeapi.Ingredient.IngredientModel ingredient) {
        ingredientRepo.save(ingredient);
        return "ingredient saved";
    }
}
