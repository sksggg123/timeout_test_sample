package com.sksggg123.socket.controller;

import com.sksggg123.socket.client.Client;
import org.springframework.web.bind.annotation.*;

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
    String main(@PathVariable(value = "data") final String data) {
        System.out.println("소켓 연결 시도 중...");
        Client client = new Client();
        return client.responseData(data);
    }
}
