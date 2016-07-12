package com.ljt.cxf.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author lijuntao1
 * @date 2016/7/12 14:24
 */
@XmlRootElement
public class MyObj {
    private String name;
    private String age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
