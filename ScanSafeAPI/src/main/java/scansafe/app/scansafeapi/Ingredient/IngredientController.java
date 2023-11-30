package scansafe.app.scansafeapi.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scansafe.app.scansafeapi.Ingredient.IngredientRepo;

import java.util.List;

@RestController
public class IngredientController {

    @Autowired
    private IngredientRepo ingredientRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "welcome!";
    }

    @CrossOrigin
    @GetMapping(value = "/ingredients")
    public List<scansafe.app.scansafeapi.Ingredient.IngredientModel> getIngredients() {
        return ingredientRepo.findAll();
    }

    @PostMapping(value = "/save-ingredient")
    public String saveIngredient(@RequestBody scansafe.app.scansafeapi.Ingredient.IngredientModel ingredient) {
        System.out.println(ingredient.getName());
        ingredientRepo.save(ingredient);
        return "ingredient saved";
    }
}
