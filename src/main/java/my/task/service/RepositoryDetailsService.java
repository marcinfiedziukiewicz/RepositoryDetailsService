package my.task.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.task.model.RemoteRepositoryDetailsResponse;
import my.task.model.RepositoryDetailsResponse;
import my.task.service.remote.RemoteRepositoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PACKAGE, onConstructor = @__(@Autowired))
@Service
public class RepositoryDetailsService {

    private final RemoteRepositoryDetailsService remoteRepositoryDetailsService;

    public RepositoryDetailsResponse getRepositoryDetails(String owner, String repositoryName) {
        RemoteRepositoryDetailsResponse remoteRepositoryDetailsResponse = remoteRepositoryDetailsService.getRemoteRepositoryDetailsResponse(owner, repositoryName);
        return RepositoryDetailsResponse.builder().cloneUrl(remoteRepositoryDetailsResponse.getCloneUrl())
                .createdAt(remoteRepositoryDetailsResponse.getCreatedAt())
                .description(remoteRepositoryDetailsResponse.getDescription())
                .fullName(remoteRepositoryDetailsResponse.getFullName())
                .stars(remoteRepositoryDetailsResponse.getStars())
                .build();
    }

}
