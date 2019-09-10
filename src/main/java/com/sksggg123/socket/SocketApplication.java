package com.sksggg123.socket;

import com.sksggg123.socket.server.SocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketApplication {

    private static SocketServer socketServer;

    public static void main(String[] args) {
        SpringApplication.run(SocketApplication.class, args);

        // socketServer 대기
        socketServer = new SocketServer();
    }
}
