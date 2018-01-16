package com.fls.profiles;

import com.fls.profiles.model.IUser;
import javafx.scene.layout.Pane;

public interface IProfile {
    Pane getProfile(long id);
    Pane getInfo(long id);
    Pane getDetailedInfo(long id);
    IUser register();
}
