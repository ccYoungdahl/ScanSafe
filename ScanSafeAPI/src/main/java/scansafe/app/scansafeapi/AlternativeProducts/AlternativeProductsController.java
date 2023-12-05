package scansafe.app.scansafeapi.AlternativeProducts;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Robby Martin
 */
@RestController
@RequestMapping("/api/alternativeProducts")
@CrossOrigin(origins = "http://localhost:3000")
public class AlternativeProductsController {
    
    @Autowired
    private AlternativeProductsRepo alternativeProductRepo;
 
    @GetMapping("/all")
    public List<AlternativeProducts> getAllAlternativeProducts() {
        return alternativeProductRepo.findAll();
    }

    @GetMapping("/{upc}")
    @PreAuthorize("hasRole('USER') or hasRole('INFLUENCER') or hasRole('ADMIN')")
    public List<AlternativeProducts> getAlternativeProductsFromUPC(@PathVariable("upc") String upc) {
        return alternativeProductRepo.findByUpc(upc);
    }
    
    @PostMapping("/save")
    public AlternativeProducts saveAlternativeProducts(@RequestBody AlternativeProducts alternativeProduct) {
        return alternativeProductRepo.save(alternativeProduct);
    }
    
}
