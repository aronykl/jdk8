package com.shengsiyuan.jdk8.channel;

import com.shengsiyuan.jdk8.stream.StreamTest1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/10 20:38
 */
public class PipeTest {

    public static void main(String[] args) throws IOException {
        WritableByteChannel out = Channels.newChannel(System.out);
        ReadableByteChannel workerChannel = startWorker(10);
        ByteBuffer buffer = ByteBuffer.allocate(100);
        while (workerChannel.read(buffer) >= 0) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    private static ReadableByteChannel startWorker(int reps) throws IOException {
        Pipe pipe = Pipe.open();
        Worker worker = new Worker(pipe.sink(), reps);
        worker.start();
        return pipe.source();
    }

    private static class Worker extends Thread {
        private WritableByteChannel channel;
        private int reps;

        public Worker(WritableByteChannel channel, int reps) {
            this.channel = channel;
            this.reps = reps;
        }

//        @Override
//        public void run() {
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            try {
//                for (int i = 0; i < this.reps; i++) {
//
//                    doSomeWork(buffer);
//                    while (channel.write(buffer) > 0) {
//
//                    }
//                }
//                this.channel.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        private String[] products = {
                "NO good deed goes unpunished",
                "To be, or what?",
                "No matter where you go, there you are",
                "Just say \"Yo\"",
                "My karma ran over my dogma"
        };

        private Random rand = new Random();

        private void doSomeWork(ByteBuffer buffer) {
            int product = rand.nextInt(products.length);
            buffer.clear();
            buffer.put(products[product].getBytes());
            buffer.put("\r\n".getBytes());
            buffer.flip();
        }
    }


}

