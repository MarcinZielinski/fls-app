package com.fls;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

public abstract class TestFXBase extends ApplicationTest {

    @Before
    public void setUpClass() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(Main.class);
    }

    @Override
    public void start(Stage stage) {
        stage.show();
    }

    @After
    public void afterEachTest() throws TimeoutException {
        FxToolkit.hideStage();
        // release every event occurred during tests
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    public <T extends Node> T find(final String fxId) throws Exception {
        return (T) lookup(fxId).tryQuery().orElseThrow(() -> new Exception(String.format("Couldn't find node with fxId: %s", fxId)));
    }
}
