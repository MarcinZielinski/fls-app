package com.fls.wall;

import com.fls.Server;
import com.fls.TestFXBase;
import com.fls.manager.Manager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.util.WaitForAsyncUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.testfx.api.FxAssert.verifyThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Server.class)
public class WallTest extends TestFXBase {

    private static final String POST_CREATOR = "#creatorPane";
    private static final String CONTENT_TEXTBOX = "#content";
    private static final String APPLY_BUTTON = "#apply";
    private static final String POSTS_VBOX = "#posts";
    private static final String OPTIONS_MENU = "#menu";
    private static final String EDIT_OPTION = "#editAction";
    private static final String DELETE_OPTION = "#deleteAct";


    private Manager manager;
    private Wall wall;

    @Before
    public void before() throws TimeoutException{
        manager = mock(Manager.class);
        wall = new Wall(manager);
        FxToolkit.setupSceneRoot(() -> wall.load());
        mockStatic(Server.class);
    }

    @Test
    public void addingEdittingAndRemovingPost() throws Exception {
        clickOn(POST_CREATOR);
        WaitForAsyncUtils.waitForFxEvents();
        String content = "Super hiper ultra post";
        clickOn(CONTENT_TEXTBOX).write(content);
        clickOn(APPLY_BUTTON);
        WaitForAsyncUtils.waitForFxEvents();
        WaitForAsyncUtils.sleep(5000, TimeUnit.MILLISECONDS);
        verifyThat(content, NodeMatchers.isNotNull());
        moveTo(OPTIONS_MENU).moveBy(10,0).clickOn();
        WaitForAsyncUtils.waitForFxEvents();
        clickOn(EDIT_OPTION);
        WaitForAsyncUtils.waitForFxEvents();
        String edittedContent = "Zedytowany:\n" + content;
        clickOn(CONTENT_TEXTBOX).eraseText(content.length()).write(edittedContent);
        clickOn(APPLY_BUTTON);
        WaitForAsyncUtils.waitForFxEvents();
        WaitForAsyncUtils.sleep(5000, TimeUnit.MILLISECONDS);
        verifyThat(edittedContent, NodeMatchers.isNotNull());
        moveTo(OPTIONS_MENU).moveBy(10,0).clickOn();
        WaitForAsyncUtils.waitForFxEvents();
        clickOn(DELETE_OPTION);
        WaitForAsyncUtils.waitForFxEvents();
        WaitForAsyncUtils.sleep(5000, TimeUnit.MILLISECONDS);
        verifyThat(edittedContent, NodeMatchers.isNull());

    }
}
