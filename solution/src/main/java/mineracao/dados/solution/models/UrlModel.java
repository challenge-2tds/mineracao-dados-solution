package mineracao.dados.solution.models;

import jakarta.persistence.*;
import lombok.*;
import mineracao.dados.solution.TypeSearch.TypeSearch;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "UrlModel")
@Entity
@Table(name = "TB_URL_MODEL")
public class UrlModel {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String url;

    @NonNull
    private String keys;

    @NonNull
    private TypeSearch typeSearch;

    @OneToMany
    @JoinColumn(name = "TB_GENERIC_ENTITY")
    private List<GenericEntity> genericEntityList;





}
