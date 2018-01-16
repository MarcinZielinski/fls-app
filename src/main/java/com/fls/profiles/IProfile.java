package com.fls.profiles;

import com.fls.profiles.model.IUser;
import javafx.scene.layout.Pane;

public interface IProfile {
    Pane getProfile(IUser user);
    Pane getInfo(IUser user);
    Pane getDetailedInfo(int user_id);
    IUser register();
}
