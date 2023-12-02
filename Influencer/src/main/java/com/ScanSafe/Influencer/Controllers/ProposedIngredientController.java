package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.ProposedIngredient;
import com.ScanSafe.Influencer.Repositories.ProposedIngredientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robby Martin
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class ProposedIngredientController {

    @Autowired
    private ProposedIngredientRepository proposedIngredientRepository;

    @GetMapping("/getProposedIngredients")
    public List<ProposedIngredient> getAllProposedIngredients() {
        return proposedIngredientRepository.findAll();
    }

    @PostMapping("/saveProposedIngredient")
    public ProposedIngredient saveProposedIngredient(@RequestBody ProposedIngredient proposedIngredient) {
        return proposedIngredientRepository.save(proposedIngredient);
    }

}