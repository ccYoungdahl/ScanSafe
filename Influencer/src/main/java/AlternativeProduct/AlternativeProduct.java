package AlternativeProduct;

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

    private String replaces_product;
    private long upc;
    private String alternative_product;
    private String notes;

    public AlternativeProduct(String replaces_product, long upc, String alternative_product, String notes) {
        this.replaces_product = replaces_product;
        this.upc = upc;
        this.alternative_product = alternative_product;
        this.notes = notes;
    }
}
