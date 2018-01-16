package com.fls.manager;

import com.fls.TestFXBase;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeoutException;

import static org.mockito.Mockito.spy;
import static org.testfx.api.FxAssert.verifyThat;

/**
 * Created by Marcin on 2017-12-12.
 */

public class ManagerTest extends TestFXBase {

    private Manager manager;

    @Before
    public void before() throws TimeoutException {
        manager = spy(new Manager(null, 0L, 0L));
        FxToolkit.setupScene(manager::getScene);
    }

    @Test
    public void sideBarAppearingTest() {
        moveTo("#sideHBox");

        WaitForAsyncUtils.waitForFxEvents();

        verifyThat("Wall", NodeMatchers.isVisible());
    }
}
