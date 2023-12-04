package scansafe.app.scansafeapi.ProposedIngredients;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robby Martin
 */
@RestController
@RequestMapping("/api/proposedIngredients")
@CrossOrigin("http://localhost:3000")
public class ProposedIngredientsController {

    @Autowired
    private ProposedIngredientsRepo proposedIngredientsRepo;

    @GetMapping("/all")
    public List<ProposedIngredients> getAllProposedIngredients() {
        return proposedIngredientsRepo.findAll();
    }

    @PostMapping("/save")
    public ProposedIngredients saveProposedIngredient(@RequestBody ProposedIngredients proposedIngredient) {
        return proposedIngredientsRepo.save(proposedIngredient);
    }
}
