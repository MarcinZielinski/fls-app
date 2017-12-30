package com.fls.util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;

/**
 * Created by Marcin on 2017-12-29.
 */
public class ImageConverter {
    public static byte[] convertToByteArray(ImageView imageView) {
        byte[] bytes = null;
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            BufferedImage buffered = SwingFXUtils.fromFXImage(imageView.getImage(), null);
            ImageIO.write(buffered, "jpg", baos);
            bytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static ImageView convertToImageView(byte[] bytes) {
        ImageView imageView = null;
        try(ByteArrayInputStream is = new ByteArrayInputStream(bytes)) {
            imageView = new ImageView(new Image(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageView;
    }
}
