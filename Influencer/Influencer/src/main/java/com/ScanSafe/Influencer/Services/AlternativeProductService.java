package com.ScanSafe.Influencer.Services;

import com.ScanSafe.Influencer.Models.AlternativeProduct;
import com.ScanSafe.Influencer.Repositories.AlternativeProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robby Martin
 */
@Service
public class AlternativeProductService {
    
    @Autowired
    private AlternativeProductRepository alternativeProductRepository;
    
    public List<AlternativeProduct> getAllAlternativeProducts(){
        return alternativeProductRepository.findAll();
    }
    
    public void saveAlternativeProduct(AlternativeProduct alternativeProduct) {
        this.alternativeProductRepository.save(alternativeProduct);
    }
    
    public AlternativeProduct getAlternativeProductByID(long id) {
        Optional<AlternativeProduct> optional = alternativeProductRepository.findById(id);
        AlternativeProduct altProduct = null;
        if(optional.isPresent()) {
            altProduct = optional.get();
        } else {
            throw new RuntimeException("Alternative product not found for id: " + id);
        }
        return altProduct;
    }
    
    public void deleteAlternativeProduct(long id) {
        this.alternativeProductRepository.deleteById(id);
    }
}
