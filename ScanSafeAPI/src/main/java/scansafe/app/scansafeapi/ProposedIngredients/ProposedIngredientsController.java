package scansafe.app.scansafeapi.ProposedIngredients;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import scansafe.app.scansafeapi.User.response.MessageResponse;

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
    @PutMapping("/approve/{id}")
    public ResponseEntity<?> Approve(@PathVariable("id") Long id) {
        ProposedIngredients proposedIngredients = proposedIngredientsRepo.findById(id).orElseThrow(() -> new RuntimeException("Error: Proposal is not found."));
        proposedIngredients.setApproved(true);
        proposedIngredientsRepo.save(proposedIngredients);
        return ResponseEntity.ok(new MessageResponse("approved"));
    }
}
