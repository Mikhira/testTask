package demo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.DTO.UserRequest;
import demo.Entity.UserEntity;
import demo.Service.UserService;
import demo.ForcelateTestTaskApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@WebMvcTest(ForcelateTestTaskApplication.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    private static final String URL_TO_SAVE_USER = "/user/save";

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testFindUserByAge() {
        List<UserEntity> userEntityList = userController.findByAge(10);
        if(Objects.isNull(userEntityList) && userEntityList.size() == 0) {
            fail();
        }
    }

    @Test
    public void testSave() throws Exception {
        UserRequest userRequest = new UserRequest();
        userRequest.setAge(17);
        userRequest.setName("Bill");
        final String inputJson = mapToJson(userRequest);

        final MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.post(URL_TO_SAVE_USER)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(inputJson))
                .andReturn();

        final int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

}
