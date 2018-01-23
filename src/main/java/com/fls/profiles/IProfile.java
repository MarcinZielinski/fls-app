package com.fls.profiles;

import com.fls.profiles.model.IUser;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public interface IProfile {
    AnchorPane getProfile(long id);
    AnchorPane getInfo(long id);
    AnchorPane getDetailedInfo(long id);
}
