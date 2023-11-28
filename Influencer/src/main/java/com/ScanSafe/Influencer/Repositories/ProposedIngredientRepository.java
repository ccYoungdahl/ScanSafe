package com.ScanSafe.Influencer.Repositories;

import com.ScanSafe.Influencer.Models.ProposedIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robby Martin
 */
@Repository
public interface ProposedIngredientRepository extends JpaRepository<ProposedIngredient, Long>{
    
}
