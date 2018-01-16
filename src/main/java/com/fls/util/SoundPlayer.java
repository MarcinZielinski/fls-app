package com.fls.util;

import javafx.event.EventTarget;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class SoundPlayer {
    private static Map<SoundEnum, AudioClip> soundMap = new HashMap<>();

    static {
        soundMap.put(SoundEnum.NEW_MESSAGE, new AudioClip(SoundPlayer.class.getResource("new_message.mp3").toExternalForm()));
        soundMap.put(SoundEnum.LOGIN, new AudioClip(SoundPlayer.class.getResource("login.wav").toExternalForm()));
        soundMap.put(SoundEnum.BUTTON_CLICK, new AudioClip(SoundPlayer.class.getResource("mouse_click.wav").toExternalForm()));
        soundMap.put(SoundEnum.KEY_PRESS, new AudioClip(SoundPlayer.class.getResource("key_press.wav").toExternalForm()));
    }

    public static void play(SoundEnum soundEnum) {
        soundMap.get(soundEnum).play();
    }

    public static Scene addSoundToScene(Scene scene) {
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            EventTarget target = event.getTarget();
            if (target instanceof Text) {
                if (((Text) target).getParent() instanceof Button) {
                    SoundPlayer.play(SoundEnum.BUTTON_CLICK);
                }
            }
            if (target instanceof Button) {
                SoundPlayer.play(SoundEnum.BUTTON_CLICK);
            }
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            if (event.getCode() == KeyCode.ENTER && scene.getFocusOwner() instanceof TextField) {
                SoundPlayer.play(SoundEnum.KEY_PRESS);
            }
        });
        return scene;
    }
}
