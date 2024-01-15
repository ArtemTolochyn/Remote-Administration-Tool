package org.example.systemController;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScreenController {

    public InputFile screenshot() throws IOException, AWTException {
        Robot robot = new Robot();

        Rectangle capture = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(capture);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);

        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());


        return new InputFile(inputStream, "screenshot.png");
    }
}
