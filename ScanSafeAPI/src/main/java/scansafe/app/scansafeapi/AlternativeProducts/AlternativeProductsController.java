package scansafe.app.scansafeapi.AlternativeProducts;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @PostMapping("/save")
    public AlternativeProducts saveAlternativeProducts(@RequestBody AlternativeProducts alternativeProduct) {
        return alternativeProductRepo.save(alternativeProduct);
    }
    
}
