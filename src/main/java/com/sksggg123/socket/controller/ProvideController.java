package com.sksggg123.socket.controller;

import com.sksggg123.socket.client.Client;
import com.sksggg123.socket.service.RestRequestService;
import com.sksggg123.socket.vo.rest.RestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
@RequestMapping(value = "/socket")
public class ProvideController {

    @Autowired
    private RestRequestService restRequestService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(@RequestParam(value = "sendData") final String sendData) {
        System.out.println("소켓 연결 시도 중 {}" + sendData);
        new Client("localhost", 30089, sendData);

        return "main";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String requestXML(@PathVariable(value = "id") String id) {

        RestVO vo = new RestVO()
                .builder(HttpServletResponse.SC_OK)
                .builder(id, "권병윤");

        return restRequestService.convertToXmlString(vo);
    }
}
