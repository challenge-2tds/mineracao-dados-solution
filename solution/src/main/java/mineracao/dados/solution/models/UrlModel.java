package mineracao.dados.solution.models;

import jakarta.persistence.*;
import lombok.*;
import mineracao.dados.solution.TypeSearch.TypeSearch;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UrlModel")
public class UrlModel {

    @Id
    @GeneratedValue
    @Field("id")
    private Long id;

    @NonNull
    @Field("url")
    private String url;

    @NonNull
    @Field("keys")
    private String keys;

    @NonNull
    @Field("typeSearch")
    private TypeSearch typeSearch;

    @OneToMany(mappedBy = "genericEntity")
    private List<GenericEntity> genericEntityList;





}
