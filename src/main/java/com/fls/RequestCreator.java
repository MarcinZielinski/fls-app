package com.fls;

import org.springframework.web.client.RestTemplate;

import static com.fls.Server.SERVER_ADDRESS;

public class RequestCreator {

    public <T> T getForObject(String endpointUrl, Class<T> returnClass, Object... urlParams) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String url = String.format("%s/%s", SERVER_ADDRESS, endpointUrl);
            return restTemplate.getForObject(url, returnClass, urlParams);
        } catch (Exception e) {
            return null;
        }
    }

    public <T> T postForObject(String endpointUrl, T objectToPost, Class<T> returnClass, Object... urlParams) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            final String url = String.format("%s%s", SERVER_ADDRESS, endpointUrl);
            return restTemplate.postForObject(url, objectToPost, returnClass, urlParams);
        } catch (Exception e) {
            return null;
        }
    }
}
