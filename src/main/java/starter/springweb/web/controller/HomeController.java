package starter.springweb.web.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import starter.springweb.web.resolver.Authenticated;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/16
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String getHome(@Authenticated String authentication) {
        return authentication;
    }

    @GetMapping("/pagination")
    public Page<String> getPagination(PageRequest pageRequest) {
        log.info("pageRequest: {}", pageRequest);

        return Page.of(pageRequest.getCount(), pageRequest.getStartIndex(), 5, false,
                List.of("data1","data2","data3","data4","data5"));
    }
}
