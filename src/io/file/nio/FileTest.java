package io.file.nio;

import java.io.*;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileTest {
    public static final ThreadPoolExecutor executor = new ThreadPoolExecutor(4,16,10L,
            TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    // -->path
    public static void write() {
        String path = "H:\\test\\test.txt";
        String pathw = "H:\\test\\copy\\copy.txt";

        File file = new File(path);
        long sile = file.length();
        long limit = sile - 2*1024*1024;
        if(limit <= 0) {
            return;
        }
        Random random = new Random();
        Thread t = new Thread(()-> {

            try(RandomAccessFile fileW = new RandomAccessFile(pathw,"rw");
                RandomAccessFile fileR = new RandomAccessFile(path,"rw");) {
                while(true) {
                    int start = random.nextInt((int) limit);
                    fileR.seek(start);
                    fileW.seek(start);
                    int len = -1;
                    int totle = 2*1024*1024;
                    byte[] bytes = new byte[1024];
         //           System.out.printf("thread = %swriter file, indek = %d\n",
         //                   Thread.currentThread().getId(), start);
                    while((len = fileR.read(bytes))!=-1) {
                        fileW.write(bytes, 0 , len);
                        totle -=len;
                        if(totle<0) {
                            break;
                        }
                    }
                 //   System.out.printf("writer file over,thread = %s\n", Thread.currentThread().getId());
                }


            }catch (IOException e) {
                System.out.println("error"+ e);
                e.printStackTrace();
            }

        });
        Lock  lock = new ReentrantLock(true);
        executor.execute(t);
        executor.execute(t);
        executor.execute(t);

    }

    // path --> outpath
    public static void copy() {
        String path = "H:\\test\\copy\\copy.txt";
        System.out.printf("copy begin\n");
        int count = 3;
        while(count > 0) {
            String outPath = "H:\\test\\copy\\" + count + ".txt";
            try( RandomAccessFile file = new RandomAccessFile(path, "rw");
                 RandomAccessFile filew = new RandomAccessFile(outPath, "rw");){
                byte[] bf = new byte[1024];
                int len = -1;
                while ((len = file.read(bf)) != -1) {
                    filew.write(bf,0,len);
                }
            }catch (IOException e){
                System.out.println("error"+ e);
                e.printStackTrace();
            }
            count--;
        }
        System.out.printf("copy over\n");


    }


    public static void main(String[] args) {
        executor.execute(FileTest::copy);
        executor.execute(FileTest::write);

    }
}
