package com.example.sentinel.demos.sentinel;

import org.apache.commons.lang3.ClassLoaderUtils;
import sun.misc.ClassLoaderUtil;

import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy(new RealHello());
        ClassLoader classLoader = TestProxy.class.getClassLoader();
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Hello test = (Hello) Proxy.newProxyInstance(classLoader, new Class[]{Hello.class}, jdkProxy);
        System.out.println(test.say());
    }
}
