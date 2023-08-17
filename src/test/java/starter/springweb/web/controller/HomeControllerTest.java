package starter.springweb.web.controller;

import org.junit.jupiter.api.Test;
import starter.springweb.domain.AbstractControllerTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */
class HomeControllerTest extends AbstractControllerTest {
    @Test
    void getPaginationWithDefault() throws Exception {
        mockMvc.perform(get("/pagination"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getPaginationWithCount() throws Exception {
        mockMvc.perform(get("/pagination?count=5"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getPaginationWithStartIndex() throws Exception {
        mockMvc.perform(get("/pagination?start_index=2"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getPaginationWithSort() throws Exception {
        mockMvc.perform(get("/pagination?sort_by=col1,asc"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void getPaginationWithAll() throws Exception {
        mockMvc.perform(get("/pagination?count=5&start_index=2&sort_by=col1,desc"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
