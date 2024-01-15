package org.example.systemController;

import java.io.IOException;

public class CMDController {
    public void execute(String command) throws Exception {
        Runtime runtime = Runtime.getRuntime();

        runtime.exec("cmd.exe /c " + command);
    }
}
