package io.file.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class NioTest {

    public void test() throws IOException {


        RandomAccessFile file = new RandomAccessFile("","rw");
        FileChannel channel = file.getChannel();
        ByteBuffer bb = ByteBuffer.allocateDirect(100);
        ByteBuffer bb2 = ByteBuffer.allocate(100);
        channel.read(bb2);



    }

    public static void main(String[] args) {

    }
}
