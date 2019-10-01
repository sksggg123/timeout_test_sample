package com.sksggg123.socket.controller;

import com.sksggg123.socket.client.SocketClientRequest;
import com.sksggg123.socket.vo.rest.request.RestVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-10 17:58
 */
@RestController
@RequestMapping(value = "/consume")
public class ConsumeController {

    @RequestMapping(value = "/socket/{data}", method = RequestMethod.GET)
    public @ResponseBody
    String socket(@PathVariable(value = "data") final String data) {
        System.out.println("소켓 연결 시도 중...");

        SocketClientRequest socketClientRequest = new SocketClientRequest();
        return socketClientRequest.responseData(data);
    }

    @RequestMapping(value = "/rest/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String getXmlType(@PathVariable(value = "id") final String id) {
        URI uri = null;
        RestTemplate rest = new RestTemplate();

        try {
            uri = new URI("http://localhost:8080/provide/kwon");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ResponseEntity<RestVO> response = rest.postForEntity(uri, "", RestVO.class);
        return response.getBody().toString();
    }
}
