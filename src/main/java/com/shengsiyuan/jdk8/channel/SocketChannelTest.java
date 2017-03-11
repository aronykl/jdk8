package com.shengsiyuan.jdk8.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/9 22:01
 */
public class SocketChannelTest {

    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 1234));

        ByteBuffer buffer = ByteBuffer.allocate(80);

        socketChannel.read(buffer);

        System.out.println(new String(buffer.array()));

    }
}
