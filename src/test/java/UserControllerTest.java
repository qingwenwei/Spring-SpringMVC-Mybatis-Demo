import com.alibaba.fastjson.JSONObject;
import com.qingwenwei.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/spring.xml", "classpath:/spring/spring-mvc.xml"} )
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private User testUser;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        testUser = new User();
        testUser.setUserName("testUser");
        testUser.setFirstName("testFirstName");
        testUser.setLastName("testLastName");
        testUser.setPhone("0000000");
        testUser.setEmail("test@gmail.com");
        testUser.setAddress("111 test");
        testUser.setYearBorn(2000);
    }

    @Test
    public void testCreateUser() throws Exception {
        String requestJson = JSONObject.toJSONString(testUser);
        mockMvc.perform(post("/user")
                .content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("SUCCESS"));
    }

    @Test
    public void testDeleteUser() throws Exception {
        testUser.setUserName("deleteTestUser");
        String requestJson = JSONObject.toJSONString(testUser);
        mockMvc.perform(post("/user")
                .content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("SUCCESS"));

        mockMvc.perform(delete("/user")
                .content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("SUCCESS"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        testUser.setUserName("kwei");
        testUser.setFirstName("kelvin");
        String requestJson2 = JSONObject.toJSONString(testUser);

        mockMvc.perform(put("/user")
                .content(requestJson2).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("SUCCESS"));
    }

    @Test
    public void testFindUser() throws Exception {
        mockMvc.perform(get("/user/username/testUser"))
                .andExpect(status().is(200));
    }
}




