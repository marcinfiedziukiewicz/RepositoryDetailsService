package my.task.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import my.task.model.RemoteRepositoryDetailsResponse;
import my.task.model.RepositoryDetailsResponse;
import my.task.service.remote.RemoteRepositoryDetailsService;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RepositoryDetailsServiceTest {

    private RemoteRepositoryDetailsService remoteRepositoryDetailsService = mock(RemoteRepositoryDetailsService.class);
    private RepositoryDetailsService repositoryDetailsService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private RemoteRepositoryDetailsResponse validRemoteRepositoryDetailsResponse;

    @Before
    public void before() {
        repositoryDetailsService = new RepositoryDetailsService(remoteRepositoryDetailsService);
        try {
            validRemoteRepositoryDetailsResponse = objectMapper.readValue(new File("src/test/resources/valid_remote_response.json"), RemoteRepositoryDetailsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getValidRepositoryDetailsResponseTest() {

        //given
        when(remoteRepositoryDetailsService.getRemoteRepositoryDetailsResponse("marcinfiedziukiewicz", "RepositoryDetailsService")).thenReturn(validRemoteRepositoryDetailsResponse);

        //when
        RepositoryDetailsResponse repositoryDetailsResponse = repositoryDetailsService.getRepositoryDetails("marcinfiedziukiewicz", "RepositoryDetailsService");

        //then
        assertThat(repositoryDetailsResponse.getCloneUrl()).isEqualTo(validRemoteRepositoryDetailsResponse.getCloneUrl());
        assertThat(repositoryDetailsResponse.getDescription()).isEqualTo(validRemoteRepositoryDetailsResponse.getDescription());
        assertThat(repositoryDetailsResponse.getFullName()).isEqualTo(validRemoteRepositoryDetailsResponse.getFullName());
        assertThat(repositoryDetailsResponse.getStars()).isEqualTo(validRemoteRepositoryDetailsResponse.getStars());
        assertThat(repositoryDetailsResponse.getCreatedAt()).isEqualTo(validRemoteRepositoryDetailsResponse.getCreatedAt());
    }
}
