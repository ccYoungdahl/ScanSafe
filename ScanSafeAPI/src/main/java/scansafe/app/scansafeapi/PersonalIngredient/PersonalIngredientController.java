package scansafe.app.scansafeapi.PersonalIngredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scansafe.app.scansafeapi.Ingredient.IngredientModel;

import java.util.List;


@RestController
@RequestMapping("/api/personal-ingredients")
public class PersonalIngredientController {

    @Autowired
    private PersonalIngredientRepo personalIngredientRepo;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    public String addIngredient(@RequestBody scansafe.app.scansafeapi.PersonalIngredient.PersonalIngredientModel ingredient) {
        personalIngredientRepo.save(ingredient);
        return "ingredient saved";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all-from-user")
    public List<scansafe.app.scansafeapi.PersonalIngredient.PersonalIngredientModel> getPersonalIngredients() {
        return personalIngredientRepo.findByUserId(1);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete/{id}")
    public String deleteIngredient(@PathVariable("id") Long id) {
        personalIngredientRepo.deleteById(id);
        return "success";
    }
}
