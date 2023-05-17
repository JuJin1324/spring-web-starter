package starter.springweb.domain.user.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import starter.springweb.external.client.apppush.PushData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/17
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@AllArgsConstructor
public class UserPushData implements PushData {
    private Long id;
    private String name;
    private Integer age;

    @Override
    public Map<String, String> toMap() throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(this.id));
        map.put("name", this.name);
        map.put("age", String.valueOf(this.age));
        return map;
    }
}
