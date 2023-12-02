package scansafe.app.scansafeapi.PersonalIngredient;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_ingredient")
public class PersonalIngredientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private long userId;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getUserId() {
        return userId;
    }
}
