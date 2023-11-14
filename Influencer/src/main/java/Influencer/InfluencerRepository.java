package Influencer;

import AlternativeProduct.AlternativeProduct;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Robby Martin
 */
public interface InfluencerRepository extends JpaRepository<AlternativeProduct, Long>{
    
    public List<AlternativeProduct> findByName(String name);

    // Below is a customized search function, which is allowed using Jpa
    //@Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.type) LIKE %?1%")
    //public List<Product> search(String keyword);
    
}
