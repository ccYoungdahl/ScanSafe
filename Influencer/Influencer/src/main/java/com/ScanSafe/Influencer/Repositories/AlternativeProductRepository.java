package com.ScanSafe.Influencer.Repositories;

import com.ScanSafe.Influencer.Models.AlternativeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robby Martin
 */
@Repository
public interface AlternativeProductRepository extends JpaRepository<AlternativeProduct, Long>{
    
}
