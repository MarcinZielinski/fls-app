package com.fls.manager;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/** Animates a node on and off screen to the left. */
public class SideBar extends VBox {
    private Animation hideSidebar;
    private Animation showSidebar;

    /** creates a sidebar containing a vertical alignment of the given nodes */
    public SideBar(final double expandedWidth, Node... nodes) {
        getStyleClass().add("sidebar");
        this.setPrefWidth(expandedWidth);

        // create a bar to hide and show.
        setAlignment(Pos.CENTER);
        getChildren().addAll(nodes);

        // create an animation to show a sidebar.
        showSidebar = new Transition() {
            { setCycleDuration(Duration.millis(250)); }
            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * frac;
                setPrefWidth(curWidth);
                setTranslateX(-expandedWidth + curWidth);
            }
        };

        // create an animation to hide sidebar.
        hideSidebar = new Transition() {
            { setCycleDuration(Duration.millis(250)); }
            protected void interpolate(double frac) {
                final double curWidth = expandedWidth * (1.0 - frac);
                setPrefWidth(curWidth);
                setTranslateX(-expandedWidth + curWidth);
            }
        };

        // start with hid sidebar
        setVisible(false);
        setPrefWidth(0);
        setTranslateX(-expandedWidth);
    }

    public void close() {
        hideSidebar.play();
    }

    public void open() {
        setVisible(true);
        showSidebar.play();
    }
}
