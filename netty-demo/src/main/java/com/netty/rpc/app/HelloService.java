package com.netty.rpc.app;

/**
 * Created by DebugSy on 2017/12/14.
 */
public interface HelloService {

	String hello(String name);

	String hello(Person person);

}
