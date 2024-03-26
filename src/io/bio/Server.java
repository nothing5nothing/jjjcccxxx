package io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        // 创建ServerSocket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4445);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        // 创建socket
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        // 创建读缓冲流
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter out  = new PrintWriter(clientSocket.getOutputStream(), true);
        // 等待读取
        String inPut = "";
        while (( inPut = in.readLine()) != null ) {
            System.out.println(inPut);
            out.write("check value： " + inPut);
            if (inPut.equals("Bye.")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
}



























