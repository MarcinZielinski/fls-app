package com.fls.util;

import javafx.scene.image.ImageView;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by Marcin on 2017-12-29.
 */

public class ImageConverterTest extends ApplicationTest {

    @Test
    public void imageConverterTest() {
        //given
        ImageView imageView = new ImageView("com.fls.user_finder/thmb.jpg");
        //when
        byte[] expectedBytes = ImageConverter.convertToByteArray(imageView);
        ImageView convertedImage = ImageConverter.convertToImageView(expectedBytes);
        //then
        assertEquals(imageView.getImage().getHeight(),convertedImage.getImage().getHeight(),10e-15);
        assertEquals(imageView.getImage().getWidth(),convertedImage.getImage().getWidth(),10e-15);
    }
}
