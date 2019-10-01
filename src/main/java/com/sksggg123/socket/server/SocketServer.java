package com.sksggg123.socket.server;

import com.sksggg123.socket.utils.ThreadTimeUtils;

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
    public static final int PORT = 30089;
    private static final String OWNER = "KWON";
    private static final String EMPTY_MESSAGE = "Request Data is Empty..!\n Please Retry";
    private static final String RETURN_OWNER_MESSAGE = "%s is Owner";
    private static final String RETURN_CLIENT_MESSAGE = "%s is SocketClientRequest";


    public SocketServer() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("[서버] 대기 상태");

            Socket socket = null;
            while((socket = server.accept()) != null) {
                System.out.println("[서버] 클라이언트 요청 수신");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = in.readLine();
                System.out.println("[서버] 클라이언트 요청 데이터 : " + input);

                boolean flag = ThreadTimeUtils.isWait(input);
                ThreadTimeUtils.wait(flag);

                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(makeResponseData(input));
                out.flush();
                System.out.println("[서버] 응답완료!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String makeResponseData(String input) {
        if ("".equals(input) || input == null) {
            return EMPTY_MESSAGE;
        }

        if (isOwner(input)) {
            return String.format(RETURN_OWNER_MESSAGE, input);
        }

        return String.format(RETURN_CLIENT_MESSAGE, input);
    }

    private boolean isOwner(String input) {
        return OWNER.equalsIgnoreCase(input);
    }
}
