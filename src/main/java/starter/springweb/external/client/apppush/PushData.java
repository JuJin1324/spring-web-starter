package starter.springweb.external.client.apppush;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/17
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */
public interface PushData {
    Map<String, String> toMap() throws JsonProcessingException;
}
