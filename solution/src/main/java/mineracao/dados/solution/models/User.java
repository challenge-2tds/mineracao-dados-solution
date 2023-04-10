package mineracao.dados.solution.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String linkProfile; //LINKEDIN
    private String mail; //LINKEDIN
    private String avaliacoes; //MAPS
    private String estrelas; //MAPS
    private String plusCode;//MAPS
    private String name; // LINKEDIN, MAPS
    private String phone; //LINKEDIN, MAPS
    private String localidade; //LINKEDIN, MAPS

}
