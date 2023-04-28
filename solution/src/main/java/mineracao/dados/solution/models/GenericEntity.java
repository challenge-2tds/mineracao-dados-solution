package mineracao.dados.solution.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "GenericEntity")
public class GenericEntity {

    @Id
    @Field("id")
    private Long id;
    private String linkProfile; //LINKEDIN
    private String mail; //LINKEDIN
    private String avaliacoes; //MAPS
    private String estrelas; //MAPS
    private String plusCode;//MAPS
    private String name; // LINKEDIN, MAPS
    private String phone; //LINKEDIN, MAPS
    private String localidade; //LINKEDIN, MAPS


    @Embedded
    private UrlModel urlModel;


}
