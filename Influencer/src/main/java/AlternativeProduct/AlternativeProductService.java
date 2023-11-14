package AlternativeProduct;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robby Martin
 */
@Service
public class AlternativeProductService {
    
    @Autowired
    private AlternativeProductRepository repo;
    
    /**
     * Get all alternative products
     * @return the list of alternative products.
     */
    public List<AlternativeProduct> getAllAlternativeProducts() {
        return repo.findAll();
    }
    
    
}
