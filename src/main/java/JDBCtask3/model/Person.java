package JDBCtask3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "get_person_by_name",
                query = "from Person where firstName like :name"
        )
})

@Entity //nurodanti, kad is sitos klases kursime duomenu bazes lentele
@Table(name = "person") //naudojama, pakeisti duomenu bazes lenteles pavadinima,
// kitu atveju naudojamas klases pavadinimas
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    @Id//pazymi, kad sitas stulpelis bus primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generavimo strategijos tipas
    @Column()//Optional, reikalinga pakeisti stulpialio name arba size

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private  String country;

}
