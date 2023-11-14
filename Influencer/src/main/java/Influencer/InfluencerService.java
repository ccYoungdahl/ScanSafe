package Influencer;

import AlternativeProduct.AlternativeProduct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robby Martin
 */

@Service
public class InfluencerService {
    
    @Autowired
    private InfluencerRepository repo;

    /**
     * Get all products.
     *
     * @return the list of products.
     */
    public List<AlternativeProduct> getAllProducts() {
        return repo.findAll();
    }
    
    
}
