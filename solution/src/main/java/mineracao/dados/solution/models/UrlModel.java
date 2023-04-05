package mineracao.dados.solution.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import mineracao.dados.solution.TypeSearch.TypeSearch;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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





}
