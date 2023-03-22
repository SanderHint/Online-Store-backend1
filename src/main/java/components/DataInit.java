package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.UserService;

/**
 * @author Sander
 */

@Component
public class DataInit {

    @Autowired
    private UserService userService;

    public void init () {

        initUser();
    }

    private void initUser () {

    }


}