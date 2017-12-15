package Manager;

/**
 * Created by Marcin on 2017-12-12.
 */
public abstract class UserSearcherController {
    private UserSearcher model;
    abstract void initizalize();
    abstract void updateModel(); //method reacting to player
}
