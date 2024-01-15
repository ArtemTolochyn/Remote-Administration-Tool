package org.example.systemController;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.video.MarvinJavaCVAdapter;
import marvin.video.MarvinVideoInterface;
import marvin.video.MarvinVideoInterfaceException;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import javax.imageio.ImageIO;
import java.io.*;


public class CameraController {
    public InputFile capture() throws IOException, MarvinVideoInterfaceException {
        MarvinVideoInterface videoAdapter = new MarvinJavaCVAdapter();
        videoAdapter.connect(0);

        MarvinImage image = videoAdapter.getFrame();

        videoAdapter.disconnect();


        MarvinImagePanel imagePanel = new MarvinImagePanel();
        imagePanel.setImage(image);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image.getBufferedImage(), "png", outputStream);
        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());


        return new InputFile(inputStream, "camera.png");
    }


}
