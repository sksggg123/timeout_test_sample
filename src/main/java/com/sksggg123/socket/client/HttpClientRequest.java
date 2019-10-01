package com.sksggg123.socket.client;

import com.sksggg123.socket.vo.rest.request.RestVO;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
    private static final int CONNECT_TIMEOUT = 2_000;
    private static final int READ_TIMEOUT = 2_000;
    private RestTemplate rest;

    public HttpClientRequest() {
        this.rest = new RestTemplate(getClientHttpRequestFactory());
    }

    public RestVO rest(String uri, Map<String, String> param) {
        RestVO responseVO = new RestVO();
        try {
            responseVO = this.rest.getForObject(uri, RestVO.class, param);
        } catch (RestClientException rce) {
            rce.printStackTrace();
        }
        return responseVO;
    }

    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

        clientHttpRequestFactory.setConnectTimeout(CONNECT_TIMEOUT);
        clientHttpRequestFactory.setReadTimeout(READ_TIMEOUT);

        return clientHttpRequestFactory;
    }

}
