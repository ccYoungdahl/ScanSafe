package com.ScanSafe.Influencer.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Robby Martin
 */
@Data
@Entity
@Table(name = "proposed_ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProposedIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private long userId;
    private String name;
    private String risk;
    private String website;
    private String comments;
    private boolean approved;
    private boolean rejected;
    
    public ProposedIngredient(String name, String risk, String website, String comments) {
        this.name = name;
        this.risk = risk;
        this.website =  website;
        this.comments = comments;
        this.approved = false;
        this.rejected = false;
    }
    
}