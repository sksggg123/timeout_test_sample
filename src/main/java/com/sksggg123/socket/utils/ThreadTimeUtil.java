package com.sksggg123.socket.utils;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : socket
 * create date  : 2019-10-02 00:07
 */
public class ThreadTimeUtil {
    private static final int THREAD_SLEEP_5 = 5_000;
    private static final int THREAD_SLEEP_1 = 1_000;

    public static Boolean isWait(String input) {
        return input.equals("wait") ? Boolean.TRUE : Boolean.FALSE;
    }

    public static void wait(boolean flag) {
        if (flag) {
            try {
                Thread.sleep(THREAD_SLEEP_5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Thread.sleep(THREAD_SLEEP_1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
