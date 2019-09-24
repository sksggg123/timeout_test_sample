package com.sksggg123.socket.client;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-22 17:44
 */
public class HttpClientRequest {
    private RestTemplate rest;

    public HttpClientRequest() {
        this.rest = new RestTemplate(new HttpComponentsClientHttpRequestFactory());;
    }

    public String post(String ip, String port, String uri) {

        return null;
    }
}
