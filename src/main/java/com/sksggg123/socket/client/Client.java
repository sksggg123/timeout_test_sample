package com.sksggg123.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-09-10 10:54
 */
public class Client {
    private Socket socket;

    private BufferedReader in;
    private PrintWriter out;

    private static final String CLOSE_MESSAGE = "[클라이언트] Socket closed... {%s}";
    private static final String RETRY_MESSAGE = "Please Rerty..";

    public String responseData(String data) {
        try {
            connect("localhost", 30089, data);
        } catch (IOException e) {
            e.printStackTrace();
            close("Connection Error");
            return RETRY_MESSAGE;
        }

        try {
            out.println(data);
            out.flush();
            String responseData = in.readLine();

            close("Success Closed");
            return responseData;
        } catch (IOException e) {

            e.printStackTrace();
            close("Read IO Error");
            return RETRY_MESSAGE;
        }
    }

    private void connect(String ip, int port, String data) throws IOException {
        socket = new Socket(ip, port);
        socket.setKeepAlive(Boolean.TRUE);
        socket.setSoTimeout(2000);

        System.out.println("[클라이언트] 서버와 연결 성공");

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("[클라이언트] 서버와의 데이터 전달연결 통로 구축 {InputStream}");

        out = new PrintWriter(socket.getOutputStream());
        System.out.println("[클라이언트] 서버와의 데이터 전달연결 통로 구축 {OutputStream}");
    }

    private void close(String message) {
        try {
            socket.close();
            System.out.println(String.format(CLOSE_MESSAGE, message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
