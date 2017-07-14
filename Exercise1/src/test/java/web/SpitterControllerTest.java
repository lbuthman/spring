package web;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import spittr.Spitter;
import spittr.web.SpitterController;
import spittr.data.SpitterRepository;

/**
 * Listing 5.14 Testing a form-displaying controller method
 */

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }
}
