package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.AlternativeProduct;
import com.ScanSafe.Influencer.Models.ProposedIngredient;
import com.ScanSafe.Influencer.Services.AlternativeProductService;
import com.ScanSafe.Influencer.Services.ProposedIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Robby Martin
 */
@Controller
public class AlternativeProductController {
    
    @Autowired
    private AlternativeProductService alternativeProductService;
    @Autowired
    private ProposedIngredientService proposedIngredientService;
    
    // Display all alternative products
    @GetMapping("/influencerDashboard")
    public String viewInfluencerDashboard(Model model) {
        model.addAttribute("alternativeProductList", alternativeProductService.getAllAlternativeProducts());
        model.addAttribute("proposedIngredientList", proposedIngredientService.getAllProposedIngredients());
        return "influencerDashboard";
    }
    
    @GetMapping("/influencerListForm")
    public String showInfluencerListForm(Model model) {
        AlternativeProduct alternativeProduct = new AlternativeProduct();
        model.addAttribute("alternativeProduct", alternativeProduct);
        return "influencerList";
    }

    @PostMapping("/saveAlternativeProduct")
    public String saveAlternativeProduct(@ModelAttribute("alternativeProduct") AlternativeProduct alternativeProduct) {
        alternativeProductService.saveAlternativeProduct(alternativeProduct);
        return "redirect:/influencerDashboard";
    }
    
    @GetMapping("/showFormForUpdate/id={altProductId}")
    public String showFormForUpdate(@PathVariable long altProductId, Model model) {
        // Get Alternative Product from the service
        AlternativeProduct altProduct = alternativeProductService.getAlternativeProductByID(altProductId);
        // Set Alternative Product as a model attribute to pre-populate the form
        model.addAttribute("alternativeProduct", altProduct);
        return "updateAlternativeProduct";
    }
    
    @GetMapping("/deleteAlternativeProduct/id={altProductId}")
    public String deleteAlternativeProduct(@PathVariable long altProductId) {
        this.alternativeProductService.deleteAlternativeProduct(altProductId);
        return "redirect:/influencerDashboard";
    }

}