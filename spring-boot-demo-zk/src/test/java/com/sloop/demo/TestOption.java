package com.sloop.demo;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.util.ArrayList;
import java.util.List;

public class TestOption {
    public static void main(String[] args) throws Exception {

        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183", 3000, event -> {
            System.out.println(event.getPath());
        });
        Thread.sleep(3000);
//        noAuth(zk);
        auth(zk);
    }

    public static void noAuth(ZooKeeper zk){
        // 创建一个目录节点
        try {
            zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
            // 创建一个子目录节点
            zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(new String(zk.getData("/testRootPath", false, null)));
            // 取出子目录节点列表
            System.out.println(zk.getChildren("/testRootPath", true));
            // 修改子目录节点数据
            zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
            System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");
            // 创建另外一个子目录节点
            zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));
            // 删除子目录节点
            zk.delete("/testRootPath/testChildPathTwo", -1);
            zk.delete("/testRootPath/testChildPathOne", -1);
            // 删除父目录节点
            zk.delete("/testRootPath", -1);
            // 关闭连接
            zk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void auth(ZooKeeper zk){
        // 创建一个目录节点
        try {
            //login
            zk.addAuthInfo("digest", "admin:123456".getBytes());
            //构造一个权限列表
            List<ACL> acls = new ArrayList<>();
            acls.add(new ACL(ZooDefs.Perms.ALL, new Id("digest", DigestAuthenticationProvider.generateDigest("admin:123456"))));
            //创建目录时并设置权限
            zk.create("/ab", "value".getBytes(), acls, CreateMode.PERSISTENT);

            System.out.println(new String(zk.getData("/ab", true, null)));
            zk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
