package com.fls.manager;

import com.fls.TestFXBase;
import org.junit.Before;
import org.junit.Test;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static javafx.scene.input.KeyCode.ENTER;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasChildren;

/**
 * Created by Marcin on 2017-12-12.
 */

public class ManagerTest extends TestFXBase {

    @Before
    public void before() throws TimeoutException, IOException {
        clickOn("Login");
    }

    @Test
    public void test () {
        moveTo("#sideBarHBox");


        WaitForAsyncUtils.waitForFxEvents();
    }
}
