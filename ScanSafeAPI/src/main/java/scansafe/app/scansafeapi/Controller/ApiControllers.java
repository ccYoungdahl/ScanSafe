package scansafe.app.scansafeapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scansafe.app.scansafeapi.Models.Ingredient;
import scansafe.app.scansafeapi.Repo.IngredientRepo;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private IngredientRepo ingredientRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "welcome!";
    }

    @CrossOrigin
    @GetMapping(value = "/ingredients")
    public List<Ingredient> getIngredients() {
        return ingredientRepo.findAll();
    }

    @PostMapping(value = "/save-ingredient")
    public String saveIngredient(@RequestBody Ingredient ingredient) {
        System.out.println(ingredient.getName());
        ingredientRepo.save(ingredient);
        return "ingredient saved";
    }
}
