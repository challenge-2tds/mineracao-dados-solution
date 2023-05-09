package mineracao.dados.solution.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Document(collection = "GenericEntity")
@Entity
@Table(name = "TB_GENERIC_ENTITY")
public class GenericEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long linkProfile; //LINKEDIN

    private String mail; //LINKEDIN

    private String avaliacoes; //MAPS

    private String estrelas; //MAPS

    private String plusCode;//MAPS

    private String name; // LINKEDIN, MAPS

    private String phone; //LINKEDIN, MAPS

    private String localidade; //LINKEDIN, MAPS


    @Embedded
    @ManyToOne
    @JoinColumn(name = "TB_URL_MODEL")
    private UrlModel urlModel;


}
