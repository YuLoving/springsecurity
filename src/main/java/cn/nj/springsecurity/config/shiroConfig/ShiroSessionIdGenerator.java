package cn.nj.springsecurity.config.shiroConfig;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * /**
 * Copyright 2008-2018 OPPO Mobile Comm Corp., Ltd, All rights reserved.*
 * Package: cn.nj.springsecurity.config.shiroConfig
 *  自定义SessionId生成器
 * @Author: zhaotianyu
 * @Date: 2019/12/26
 */
public class ShiroSessionIdGenerator implements SessionIdGenerator {

    /**
     * 实现SessionId生成
     * @Author Sans
     * @CreateTime 2019/6/11 11:54
     */
    @Override
    public Serializable generateId(Session session) {
        Serializable  idGenerator = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s",idGenerator);
    }


}
