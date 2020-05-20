package com.wangyy.ltd.eurekafeignclient.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class MyIRule extends AbstractLoadBalancerRule {
    private int firstIndex = -1;
    private int twiceIndex = -1;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {}

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer lb,Object o) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                //在此处获取要调用的服务器下标
//                int index = this.chooseRandomInt(serverCount);


                int index = chooseIndex(serverCount);
                server = (Server)upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    private int chooseIndex(int serverCount){
        int nowIndex = new Random().nextInt(serverCount);
        System.out.println("获取的随机数字为-------->" + nowIndex);
        if (firstIndex == -1){
            firstIndex = nowIndex;
            System.out.println("firstIndex ----> " + firstIndex);
            return nowIndex;
        }


        if (twiceIndex == -1 ) {
            twiceIndex = nowIndex;
            System.out.println("firstIndex --> " + firstIndex);
            System.out.println("twiceIndex --> " + twiceIndex);
            return nowIndex;
        }
        System.out.println("firstIndex ----> " + firstIndex);
        System.out.println("twiceIndex ----> " + twiceIndex);

        if (twiceIndex == firstIndex) {
            nowIndex = new Random().nextInt(2);
            System.out.println("前两次相同，最新一次获取为 --> " + nowIndex);
        }else {
//                 nowIndex = index;
            System.out.println("前两次不同，最新一次获取为 --> " + nowIndex);
        }


        firstIndex = twiceIndex;
        twiceIndex = nowIndex;

        return nowIndex;
    }
}
