package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.AlternativeProduct;
import com.ScanSafe.Influencer.Repositories.AlternativeProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/alternativeProducts")
@CrossOrigin("http://localhost:3000")
public class AlternativeProductController {

    @Autowired
    private AlternativeProductRepository alternativeProductRepository;
    
    @GetMapping("/all")
    public List<AlternativeProduct> getAllAlternativeProducts() {
        return alternativeProductRepository.findAll();
    }
    
    @PostMapping("/save")
    public AlternativeProduct saveAlternativeProduct(@RequestBody AlternativeProduct alternativeProduct) {
        return alternativeProductRepository.save(alternativeProduct);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteAlternativeProduct(@PathVariable long id) {
        alternativeProductRepository.deleteById(id);
    }
    
    @GetMapping("/altProduct/{id}")
    public AlternativeProduct getAlternativeProductById(@PathVariable long id) {
        return alternativeProductRepository.findById(id).get();
    }
    
    @PutMapping("/altProduct/{id}")
    public AlternativeProduct updateAlternativeProduct(@PathVariable long id, @RequestBody AlternativeProduct alternativeProduct) {
        AlternativeProduct updatedAlternativeProduct = alternativeProductRepository.findById(id).get();
        
        updatedAlternativeProduct.setAltProduct(alternativeProduct.getAltProduct());
        updatedAlternativeProduct.setReplacesProduct(alternativeProduct.getReplacesProduct());
        updatedAlternativeProduct.setUpc(alternativeProduct.getUpc());
        updatedAlternativeProduct.setNotes(alternativeProduct.getNotes());
        
        return alternativeProductRepository.save(updatedAlternativeProduct);
    }
    
    /*
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

*/

}
