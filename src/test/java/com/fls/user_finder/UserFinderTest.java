package com.fls.user_finder;

import com.fls.Server;
import com.fls.TestFXBase;
import com.fls.entities.User;
import com.fls.manager.Manager;
import com.fls.util.ImageConverter;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testfx.api.FxToolkit;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.util.WaitForAsyncUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.testfx.api.FxAssert.verifyThat;

/**
 * Created by Marcin on 2017-12-29.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Server.class)
public class UserFinderTest extends TestFXBase {

    private static final String SEARCH_RESULTS_VBOX = "#searchResultsVBox";
    private static final String ADVANCED_SEARCH_PANE = "#advancedSearchPane";
    private static final String ENGLISH_CHECKBOX = "#englishCheckbox";
    private static final String NAME_TEXT_FIELD = "#nameTextField";
    private static final String ADD_SPOKEN_LANGUAGE_BUTTON = "#addSpokenLanguageButton";
    private static final String PROGRAMMING_LANGUAGES_TEXT_FIELD = "#programmingLangsTextField";
    private static final String EXPERIENCE_SLIDEDR = "#experienceSlider";
    private static final String POINTS_FLS_TEXT_FIELD = "#pointsFls";
    private static final String POINTS_STACK_TEXT_FIELD = "#pointsStack";
    private static final String ADVANCED_SEARCH_BUTTON = "#advancedSearchButton";

    private static Parent root;
    private UserFinder userFinder;
    private Manager manager;


    @Before
    public void before() throws TimeoutException, IOException {
        manager = mock(Manager.class);
        userFinder = new UserFinder(manager);
        FxToolkit.setupSceneRoot(() -> userFinder.load("Samplequery"));
        mockStatic(Server.class);
    }

    @Test
    public void userFillingTest() throws Exception {
        //given:
        byte[] image = ImageConverter.convertToByteArray(new ImageView("com.fls.user_finder/thmb.jpg"));
        ArrayList<User> users = Stream.of(new User(1L, 1L, "Andrzej", "Duda", image), new User(2L, 2L, "Andrzej", "Dudaszek", image)).collect(Collectors.toCollection(ArrayList::new));

        when(Server.getUsers(any(User.class))).thenReturn(users);

        VBox vBox = find(SEARCH_RESULTS_VBOX);
        //when:
        Platform.runLater(() -> userFinder.searchForUsers(new User("Andrzej","Duda")));
        WaitForAsyncUtils.sleep(4L, SECONDS); // wait for server response
        //then:
        verifyThat("Andrzej Duda", NodeMatchers.isNotNull());
        assertEquals(users.size(), vBox.getChildren().size());
    }

    @Test
    public void advancedSearchTest() throws Exception {
        clickOn(ADVANCED_SEARCH_PANE);
        WaitForAsyncUtils.waitForFxEvents(); // wait for accordion animation to complete
        clickOn(NAME_TEXT_FIELD).write("James van Bond");

        CheckBox checkBox = find(ENGLISH_CHECKBOX);
        clickOn(ENGLISH_CHECKBOX);
        verifyThat(checkBox, CheckBox::isSelected);

        clickOn(ADD_SPOKEN_LANGUAGE_BUTTON);
        clickOn(obj -> obj instanceof ComboBox).clickOn("Russian");
        verifyThat((ComboBox)(lookup(obj -> obj instanceof ComboBox)).tryQuery().get(), (ComboBox comboBox) -> comboBox.getSelectionModel().getSelectedItem().equals("Russian"));

        clickOn(PROGRAMMING_LANGUAGES_TEXT_FIELD).write("C#;Java;C++");

        clickOn(POINTS_FLS_TEXT_FIELD).push(KeyCode.BACK_SPACE).write("5");

        TextField stackTextField = find(POINTS_STACK_TEXT_FIELD);
        clickOn(POINTS_STACK_TEXT_FIELD).write("ASDF");
        verifyThat(stackTextField, NodeMatchers.hasText("0"));

        mockStatic(Server.class);
        clickOn(ADVANCED_SEARCH_BUTTON);

        final ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verifyStatic(Server.class);
        Server.getUsers(captor.capture());
        User expectedUser = new User(
                "James","van Bond",
                new HashSet<>(Arrays.asList("Russian", "English")),
                new HashSet<>(Arrays.asList("C#", "Java", "C++")),
                0, 5, 0, 0);
        expectedUser.setTokenId(0L);
        assertEquals(expectedUser, captor.getValue());
    }

    @Test
    public void loadProfilesWhenClicked() throws Exception {
        //given:
        byte[] image = ImageConverter.convertToByteArray(new ImageView("com.fls.user_finder/thmb.jpg"));
        ArrayList<User> users = Stream.of(new User(1L, 1L, "Andrzej", "Duda", image), new User(2L, 2L, "Andrzej", "Dudaszek", image)).collect(Collectors.toCollection(ArrayList::new));
        // when:
        mockStatic(Server.class);
        when(Server.getUsers(any(User.class))).thenReturn(users);

        Platform.runLater(() -> userFinder.searchForUsers(new User("Andrzej","Duda")));
        WaitForAsyncUtils.sleep(4L, SECONDS); // wait for server response

        clickOn("Andrzej Dudaszek");
        // then:
        verify(manager).loadProfile(2L);
    }
}
