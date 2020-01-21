package cn.nj.springsecurity.MQ;

import java.io.Serializable;

/**
 * /**
 * Package: cn.nj.springsecurity.MQ
 *
 * 测试mq的消息实体类
 * @Author: zhaotianyu
 * @Date: 2020/1/21
 */
public class test implements Serializable {

    private String loginName;
    private String pwd;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
