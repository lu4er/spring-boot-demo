package com.sloop.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.api.UnhandledErrorListener;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoZkApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", 1000 * 60, 1000 * 15, new RetryNTimes(10, 5000));
        client.start();
        CuratorFrameworkState state = client.getState();
        System.out.println("连接状态：" + state);
        List<String> children = client.getChildren().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent watchedEvent) throws Exception {
                System.out.println("监控：" + watchedEvent);
            }
        }).forPath("/");
        System.out.println("节点列表：" + children);

        String result = client.create().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath("/test", "Data".getBytes());
        System.out.println("创建节点：" + result);

        // 设置节点数据
        client.setData().forPath("/test", "test1".getBytes());
        client.setData().forPath("/test", "test2".getBytes());

        List<String> children1 = client.getChildren().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent watchedEvent) throws Exception {
                System.out.println("监控：" + watchedEvent);
            }
        }).forPath("/");
        System.out.println("节点列表：" + children1);

        Stat stat = client.checkExists().forPath("/test");
        System.out.println("检查节点：" + stat);

        Void aVoid = client.delete().withVersion(-1).forPath("/test");
        System.out.println("删除节点：" + aVoid);
        System.out.println(client.checkExists().forPath("/test"));

        //关闭连接
        client.close();

        client.getCuratorListenable().addListener(new CuratorListener() {
            @Override
            public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("事件" + curatorEvent);
            }
        });

        client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
            @Override
            public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
                System.out.println("连接状态事件" + connectionState);
            }
        });

        client.getUnhandledErrorListenable().addListener(new UnhandledErrorListener() {
            @Override
            public void unhandledError(String s, Throwable throwable) {
                System.out.println("错误事件" + s);
            }
        });


    }

}
