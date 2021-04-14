package HibernateTask1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
//@Table papildomos config leneteles
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@collumn leidzia configint stulpeli
    private String name;
    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "book_id", unique = true) // veikia kaip foreign key
    private Book book;

}
