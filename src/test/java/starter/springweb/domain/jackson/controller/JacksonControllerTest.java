package starter.springweb.domain.jackson.controller;

import org.junit.jupiter.api.Test;
import starter.springweb.domain.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/13
 */

class JacksonControllerTest extends AbstractControllerTest {

    @Test
    void getUtcDate() throws Exception {
        String requestBody = "{ \"createDate\": \"2023-04-13T21:11:11.333+09:00\"}";

        mockMvc.perform(post("/jackson/date")
                .contentType(APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getTrimStr() throws Exception {
        String requestBody = "{ \"str\": \"  3456789  \"}";

        mockMvc.perform(post("/jackson/trim")
                        .contentType(APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
