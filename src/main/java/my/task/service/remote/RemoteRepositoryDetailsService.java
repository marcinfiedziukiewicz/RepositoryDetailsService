package my.task.service.remote;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.task.model.RemoteRepositoryDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

/**
 * Service responsible for providing response from remote REST API endpoint.
 */
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE, onConstructor = @__(@Autowired))
@Service
public class RemoteRepositoryDetailsService {

    private final RestTemplate restTemplate;

    private final String GITHUB_REST_API_URL = "https://api.github.com/repos/{0}/{1}";
    private final MessageFormat messageFormat = new MessageFormat(GITHUB_REST_API_URL);

    public RemoteRepositoryDetailsResponse getRemoteRepositoryDetailsResponse(String owner, String repositoryName) {
        return getRemoteRepositoryDetailsHttpEntity(owner, repositoryName).getBody();
    }

    private HttpEntity<RemoteRepositoryDetailsResponse> getRemoteRepositoryDetailsHttpEntity(String owner, String repositoryName) {
        return restTemplate.getForEntity(messageFormat.format(new String[]{owner, repositoryName}), RemoteRepositoryDetailsResponse.class);
    }
}
