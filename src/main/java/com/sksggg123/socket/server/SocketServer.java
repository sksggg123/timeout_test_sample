package com.sksggg123.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-10 10:22
 */
public class SocketServer {
    private ServerSocket server;
    private Socket socket;

    private BufferedReader in;
    private PrintWriter out;

    public SocketServer() {
        try {
            server = new ServerSocket(30089);
            System.out.println("[서버] 대기 상태");

            socket = server.accept();
            System.out.println("[서버] 클라이언트 요청 수신");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input = in.readLine();
            System.out.println("[서버] 클라이언트 요청 데이터 : " + input);

            boolean flag = isWait(input);
            wait(flag);

            out = new PrintWriter(socket.getOutputStream());
            System.out.println("[서버] 클라이언트로 보낼 데이터");
            out.println("데이터 보냅니다.");
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                System.out.println("[서버] Server closed...");
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                System.out.println("[서버] Socket closed...");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            new SocketServer();
            System.out.println("[서버] 대기 상태 재진입");

        }
    }

    private Boolean isWait(String input) {
        return input.equals("wait") ? Boolean.TRUE : Boolean.FALSE;
    }

    private void wait(boolean flag) {
        if (flag) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
