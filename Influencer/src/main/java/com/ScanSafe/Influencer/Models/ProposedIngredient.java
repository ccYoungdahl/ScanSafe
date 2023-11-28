package com.ScanSafe.Influencer.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "proposed_ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProposedIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String risk;
    private String website;
    @Lob
    private byte[] file;
    private String comments;
    private boolean approved;
    private boolean rejected;
    
    public ProposedIngredient(String name, String risk, String website, byte[] file, String comments, boolean approved, boolean rejected) {
        this.name = name;
        this.risk = risk;
        this.website =  website;
        this.file = file;
        this.comments = comments;
        this.approved = approved;
        this.rejected = rejected;
    }
    
}
