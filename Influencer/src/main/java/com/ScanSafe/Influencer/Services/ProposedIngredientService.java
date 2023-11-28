package com.ScanSafe.Influencer.Services;

import com.ScanSafe.Influencer.Models.ProposedIngredient;
import com.ScanSafe.Influencer.Repositories.ProposedIngredientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Robby Martin
 */
@Service
public class ProposedIngredientService {

    @Autowired
    private ProposedIngredientRepository proposedIngredientRepository;

    public List<ProposedIngredient> getAllProposedIngredients() {
        return proposedIngredientRepository.findAll();
    }

    public void saveProposedIngredient(ProposedIngredient proposedIngredient) {
        this.proposedIngredientRepository.save(proposedIngredient);
    }

    public void deleteProposedIngredient(long id) {
        this.proposedIngredientRepository.deleteById(id);
    }
    
        public ProposedIngredient getProposedIngredientByID(long id) {
        Optional<ProposedIngredient> optional = proposedIngredientRepository.findById(id);
        ProposedIngredient propIngredient = null;
        if(optional.isPresent()) {
            propIngredient = optional.get();
        } else {
            throw new RuntimeException("Ingedient proposal not found for id: " + id);
        }
        return propIngredient;
    }
}
