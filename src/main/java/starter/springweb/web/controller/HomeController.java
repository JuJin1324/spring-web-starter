package starter.springweb.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import starter.springweb.web.resolver.Authenticated;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/16
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@RestController
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String getHome(@Authenticated String authentication) {
        return authentication;
    }
}
