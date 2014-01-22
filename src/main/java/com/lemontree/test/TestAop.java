package com.lemontree.test;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * User: Jasic
 * Date: 13-12-30
 */
@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestAop {

    public void doActual(String a, Integer b) {
        System.out.printf("-----------真实的动作...." + a + "," + b);
    }

    public static void main(String[] args) {
        System.out.println("你发");
    }
}
