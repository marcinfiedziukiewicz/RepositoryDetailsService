package my.task.rest;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import my.task.model.RepositoryDetailsResponse;
import my.task.service.RepositoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE, onConstructor = @__(@Autowired))
public class RepositoryDetailsRestHandler {

    private final RepositoryDetailsService repositoryDetailsService;

    @RequestMapping(value = "/repositories/{owner}/{repository-name:.+}", method = GET, produces = APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    RepositoryDetailsResponse
    getRepositoriesDetails(@PathVariable String owner, @PathVariable("repository-name") String repositoryName) {
        return repositoryDetailsService.getRepositoryDetails(owner, repositoryName);
    }

}