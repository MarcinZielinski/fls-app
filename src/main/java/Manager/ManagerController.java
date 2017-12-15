package Manager;

import javafx.fxml.FXML;

/**
 * Created by Marcin on 2017-12-12.
 */
public class ManagerController {
    private Manager model;
    @FXML
    public void initialize() {}

    public Manager getModel() {return model;}
    public void setModel(Manager model) {this.model = model;}
}
