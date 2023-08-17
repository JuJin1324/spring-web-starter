package starter.springweb.domain.user.controller;

import org.junit.jupiter.api.Test;
import starter.springweb.domain.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */

class UserControllerTest extends AbstractControllerTest {

    @Test
    void getUsersPage() throws Exception {
        mockMvc.perform(get("/users?page=1&size=5"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
