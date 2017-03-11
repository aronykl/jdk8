package com.shengsiyuan.jdk8.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/9 21:41
 */
public class ChannelAccept {

    public static final String GREETING = "Hello I must be going.\r\n";

    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 1234;

        ByteBuffer buffer = ByteBuffer.wrap(GREETING.getBytes());

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();

        serverSocket.bind(new InetSocketAddress(port));
        //通道设置非阻塞模式
        serverSocketChannel.configureBlocking(false);

        while (true) {
            System.out.println("Waiting for connections...");
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (null == socketChannel) {//表示没有连接
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from:"
                + socketChannel.socket().getRemoteSocketAddress());
                //讲缓冲position设置为0
                buffer.rewind();
                socketChannel.write(buffer);
                socketChannel.close();
            }

        }
    }
}
