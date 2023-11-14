package Influencer;

import Influencer.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/influencer")
@Controller
public class InfluencerController {
    
    @Autowired
    private InfluencerService influencerService;
    
    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                influencerService.getAllProducts());
        return "influencer/list-products";
    }
    
}
