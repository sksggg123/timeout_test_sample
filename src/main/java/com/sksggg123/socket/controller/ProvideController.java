package com.sksggg123.socket.controller;

import com.sksggg123.socket.utils.ConvertUtil;
import com.sksggg123.socket.utils.ThreadTimeUtil;
import com.sksggg123.socket.vo.rest.request.RestVO;
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
@RequestMapping(value = "/provide")
public class ProvideController {

    @Autowired
    private ConvertUtil convertUtil;

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/xml")
    public @ResponseBody
    String requestXML(@PathVariable(value = "id") String id) {
        System.out.println("[서버] 데이터 요청 " + id);
        ThreadTimeUtil.wait(ThreadTimeUtil.isWait(id));

        return convertUtil.convertToXmlString(
                new RestVO()
                        .builder(HttpServletResponse.SC_OK)
                        .builder(id, "권병윤"));
    }
}
