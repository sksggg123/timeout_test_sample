package com.sksggg123.socket.controller;

import com.sksggg123.socket.client.HttpClientRequest;
import com.sksggg123.socket.client.SocketClientRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println("[클라이언트] 소켓 연결 시도 중...");

        SocketClientRequest socketClientRequest = new SocketClientRequest();
        return socketClientRequest.responseData(data);
    }

    @RequestMapping(value = "/rest/{id}", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    String getXmlType(@PathVariable(value = "id") final String id) {
        HttpClientRequest request = new HttpClientRequest();
        Map<String, String> param = new HashMap<>();
        param.put("id", id);

        return request.rest("http://localhost:8080/provide/{id}", param).toString();
    }
}
