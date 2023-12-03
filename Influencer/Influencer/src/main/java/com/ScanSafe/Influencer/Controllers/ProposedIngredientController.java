package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.ProposedIngredient;
import com.ScanSafe.Influencer.Repositories.ProposedIngredientRepository;
import com.ScanSafe.Influencer.Services.ProposedIngredientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class ProposedIngredientController {

    @Autowired
    private ProposedIngredientRepository proposedIngredientRepository;

    @GetMapping("/all")
    public List<ProposedIngredient> getAllProposedIngredients() {
        return proposedIngredientRepository.findAll();
    }

    @PostMapping("/save")
    public ProposedIngredient saveProposedIngredient(@RequestBody ProposedIngredient proposedIngredient) {
        return proposedIngredientRepository.save(proposedIngredient);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProposedIngredient(@PathVariable long id) {
        proposedIngredientRepository.deleteById(id);
    }

    @GetMapping("/propIngredient/{id}")
    public ProposedIngredient getProposedIngredientById(@PathVariable long id) {
        return proposedIngredientRepository.findById(id).get();
    }

    @PutMapping("/propIngredient/{id}")
    public ProposedIngredient updateProposedIngredient(@PathVariable long id, @RequestBody ProposedIngredient proposedIngredient) {
        ProposedIngredient updatedProposedIngredient = proposedIngredientRepository.findById(id).get();

        updatedProposedIngredient.setName(proposedIngredient.getName());
        updatedProposedIngredient.setRisk(proposedIngredient.getRisk());
        updatedProposedIngredient.setWebsite(proposedIngredient.getWebsite());
        updatedProposedIngredient.setComments(proposedIngredient.getComments());

        return proposedIngredientRepository.save(updatedProposedIngredient);
    }

    @GetMapping("/findByName/{name}")
    public boolean getIngredientByName(@PathVariable String name) {
        if (name.toLowerCase().equals(proposedIngredientRepository.findByName(name).getName().toLowerCase())) {
            return true;
        } else {
            return false;
        }
    }
}
