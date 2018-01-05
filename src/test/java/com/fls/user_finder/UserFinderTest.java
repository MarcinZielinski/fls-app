package com.fls.user_finder;

import com.fls.Server;
import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.util.ImageConverter;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by Marcin on 2017-12-29.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Server.class)
public class UserFinderTest extends ApplicationTest {
    @Test
    public void userFillingTest() throws IOException, IllegalAccessException {
        //given:
        UserFinder userFinder = new UserFinder();
        byte[] image = ImageConverter.convertToByteArray(new ImageView("com.fls.user_finder/thmb.jpg"));
        ArrayList<User> users = Stream.of(new User(1L, 1L, "Andrzej", "Duda", image), new User(2L, 2L, "Andrzej", "Dudaszek", image)).collect(Collectors.toCollection(ArrayList::new));
        mockStatic(Server.class);
        //when:
        when(Server.getUsers(new User("Andrzej", "Duda"))).thenReturn(users);
        Pane root = userFinder.load("Andrzej Duda");
        VBox vBox = (VBox) root.getChildren().stream().filter(node -> node instanceof VBox).findFirst().orElse(new VBox());
        //then:
        assertEquals(users.size(), vBox.getChildren().size());
    }

    @Test
    public void loadProfilesWhenClicked() {
        //given
        Manager manager = mock(Manager.class);
        UserFinder userFinder = new UserFinder(manager);
        byte[] image = ImageConverter.convertToByteArray(new ImageView("com.fls.user_finder/thmb.jpg"));
        ArrayList<User> users = Stream.of(new User(1L, 1L, "Andrzej", "Duda", image), new User(2L, 2L, "Andrzej", "Dudaszek", image)).collect(Collectors.toCollection(ArrayList::new));
        // when:
        when(Server.getUsers(new User("Andrzej", "Duda"))).thenReturn(users);
        Pane root = userFinder.load("Andrzej Duda");
        VBox vBox = (VBox) root.getChildren().stream().filter(node -> node instanceof VBox).findFirst().orElse(new VBox());
        HBox hBox = (HBox) root.getChildren().get(1);
        clickOn(hBox);
        // then:
        verify(manager).loadProfile(2L);
    }
}
