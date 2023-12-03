package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.AlternativeProduct;
import com.ScanSafe.Influencer.Repositories.AlternativeProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author Robby Martin
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AlternativeProductController {

    @Autowired
    private AlternativeProductRepository alternativeProductRepository;
    
    @GetMapping("/getAlternativeProducts")
    public List<AlternativeProduct> getAllProposedIngredients() {
        return alternativeProductRepository.findAll();
    }
    
    @PostMapping("/saveAlternativeProduct")
    public AlternativeProduct saveProposedIngredient(@RequestBody AlternativeProduct alternativeProduct) {
        return alternativeProductRepository.save(alternativeProduct);
    }

    //Get alternative product by user id
    @GetMapping("/alternativeProduct/{userId}")
    public Optional<AlternativeProduct> getAlternativeProductByUserId(@PathVariable Long id) {
        Optional<AlternativeProduct> alternativeProduct = alternativeProductRepository.findById(id);
  
        return alternativeProduct;
    }
    
    //Update alternative product
    @PutMapping("/alternativeProduct/{id}")
    public AlternativeProduct updateAlternativeProduct(@PathVariable Long id, @RequestBody AlternativeProduct alternativeProductDetails) {
        
        Optional<AlternativeProduct> alternativeProduct = alternativeProductRepository.findById(id);

    }
}
