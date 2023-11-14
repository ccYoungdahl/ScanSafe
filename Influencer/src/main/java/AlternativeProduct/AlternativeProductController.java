package AlternativeProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Robby Martin
 */
@Controller
@RequestMapping("/influencerDashboard")
public class AlternativeProductController {
    
    @Autowired
    AlternativeProductService alternativeProductService;

    @GetMapping("/influencerDashboard")
    public String getAllAlternativeProducts(Model model) {
        model.addAttribute("alternativeProductList",
                alternativeProductService.getAllAlternativeProducts());
        return "influencerDashboard";
    }
}
