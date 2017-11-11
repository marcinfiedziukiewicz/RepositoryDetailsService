package my.task.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class RepositoryDetailsResponse implements Serializable {

    private String fullName;
    private String description;
    private String cloneUrl;
    private String stars;
    private String createdAt;
}
