package org.example.systemController;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HotKey {
    Boolean localStatus = true;

    Thread thread = new Thread(() -> {

        while (true)
        {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!localStatus)
            {
                try {
                    mouseMove();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });

    public void mouseStatus(Boolean status)
    {
        localStatus = status;
    }

    public void mouseLock()
    {
        thread.start();
    }

    public void linkedin() throws Exception {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_L);


        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_L);
    }

    public void f4() throws Exception {
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);

        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);
    }

    public void mouseMove() throws Exception {
        Robot robot = new Robot();

        robot.mouseMove(0, 0);
    }
}
