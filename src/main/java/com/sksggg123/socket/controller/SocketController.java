package com.sksggg123.socket.controller;

import com.sksggg123.socket.client.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-10 10:15
 */
@RestController
public class SocketController {

    @RequestMapping(value = "/socket", method = RequestMethod.GET)
    public String main(@RequestParam(value = "sendData") final String sendData) {
        System.out.println("소켓 연결 시도 중 {}" + sendData);
        new Client("localhost", 30089, sendData);

        return "main";
    }
}
