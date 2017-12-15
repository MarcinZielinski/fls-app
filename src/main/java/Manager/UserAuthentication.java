package Manager;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Created by Marcin on 2017-12-12.
 */
public class UserAuthentication {
    private Main main;
    private Scene scene;

    public UserAuthentication(Main main) {
        this.main = main;
        this.scene = null;
    }

    public Pane load() {return null;}

    public Scene getScene() {
        return scene;
    }
}
