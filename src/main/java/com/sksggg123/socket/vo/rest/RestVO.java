package com.sksggg123.socket.vo.rest;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-10 15:49
 */

@XmlRootElement(name = "RESPONSE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"header", "body"})
public class RestVO {

    @XmlElement(name = "HEADER")
    private RestHeader header;

    @XmlElement(name = "BODY")
    private RestBody body;

    public RestVO() {
        this.header = new RestHeader();
        this.body = new RestBody();
    }

    public RestVO builder(int resultCode) {
        if (HttpServletResponse.SC_OK == resultCode) {
            header.setResult("success");
            header.setResultCode(resultCode);
            return this;
        }

        header.setResult("fail");
        header.setResultCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return this;
    }

    public RestVO builder(String id, String name) {
        if (!"".equals(id) && !"".equals(name)) {
            body.setId(id);
            body.setName(name);
            return this;
        }
        body.setId("anonymous");
        body.setName("anonymous");
        return this;
    }
}
