package com.sloop.demo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 分布式配置中心
 * https://blog.csdn.net/java_66666/article/details/81015302
 */
public class ZooKeeperProSync implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();



    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        String path = "/username";
        zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183", 5000, new ZooKeeperProSync());
        connectedSemaphore.await();
        System.out.println(new String(zk.getData(path,true,stat)));
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()){
            if (Event.EventType.None == watchedEvent.getType() && null == watchedEvent.getPath()){
                connectedSemaphore.countDown();
            } else if (Event.EventType.NodeDataChanged == watchedEvent.getType()){
                try {
                    try {
                        System.out.println("配置已修改为："+new String(zk.getData(watchedEvent.getPath(),true,stat)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
