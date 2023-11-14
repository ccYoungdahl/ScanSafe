package Influencer;

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
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String type;
    private double price;

    public Influencer(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
