package Controllers;

import static org.junit.Assert.*;
import org.junit.Test;
import spittr.controller.HomeController;

/**
 * Listing 5.5 HomeControllerTest: tests HomeController
 */

public class HomeControllerTest {

    @Test
    public void testHomePage() {
        HomeController controller = new HomeController();
        assertEquals("home", controller.home());
    }
}
