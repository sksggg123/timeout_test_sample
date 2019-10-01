package com.sksggg123.socket.vo.rest.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-10 15:59
 */
@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestBody {

    @XmlElement(name = "ID")
    private String id;

    @XmlElement(name = "NAME")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RestBody{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
