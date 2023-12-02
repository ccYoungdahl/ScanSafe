package com.ScanSafe.Influencer.Controllers;

import com.ScanSafe.Influencer.Models.AlternativeProduct;
import com.ScanSafe.Influencer.Repositories.AlternativeProductRepository;
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
}