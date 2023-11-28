package com.ScanSafe.Influencer.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Robby Martin
 */
@Entity
@Table(name = "alternative_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlternativeProduct {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String altProduct;
    private String replacesProduct;
    private String upc;
    private String notes;
    
    public AlternativeProduct(String altProduct, String replacesProduct, String upc, String notes) {
        this.altProduct = altProduct;
        this.replacesProduct = replacesProduct;
        this.upc = upc;
        this.notes = notes;
    }
    
    
}
