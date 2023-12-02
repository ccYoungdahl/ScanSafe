package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.ProposedIngredient;
import com.ScanSafe.Influencer.Repositories.ProposedIngredientRepository;
import com.ScanSafe.Influencer.Services.ProposedIngredientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /*
    @GetMapping("/influencerWatchlistForm")
    public String showInfluencerWatchlistForm(Model model) {
        ProposedIngredient proposedIngredient = new ProposedIngredient();
        model.addAttribute("proposedIngredient", proposedIngredient);
        return "influencerForm";
    }

    @GetMapping("/deleteProposedIngredient/id={propIngredientId}")
    public String deleteAlternativeProduct(@PathVariable long propIngredientId) {
        this.proposedIngredientService.deleteProposedIngredient(propIngredientId);
        return "redirect:/influencerDashboard";
    }

    @GetMapping("/showFormForPropUpdate/id={propIngredientId}")
    public String showFormForPropUpdate(@PathVariable long propIngredientId, Model model) {
        // Get Alternative Product from the service
        ProposedIngredient propIngredient = proposedIngredientService.getProposedIngredientByID(propIngredientId);
        // Set Alternative Product as a model attribute to pre-populate the form
        model.addAttribute("proposedIngredient", propIngredient);
        return "updateProposedIngredient";
    }
     */
}
