package my.task.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Application main configuration class.
 */
@Configuration
public class ApplicationConfiguration {

    @Value("${resttemplate.readTimeout:2500}")
    private int readTimeout;
    @Value("${resttemplate.connectTimeout:2500}")
    private int connectTimeout;
    @Value("${resttemplate.connectionRequestTimeout:2500}")
    private int connectionRequestTimeout;

    @Bean
    public RestTemplate getRestTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(connectionRequestTimeout);
        httpRequestFactory.setConnectTimeout(connectTimeout);
        httpRequestFactory.setReadTimeout(readTimeout);
        return new RestTemplate(httpRequestFactory);
    }
}
