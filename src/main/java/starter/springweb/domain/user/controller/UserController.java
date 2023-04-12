package starter.springweb.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import starter.springweb.domain.user.service.UserReadDto;
import starter.springweb.domain.user.service.UserService;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public Page<UserReadDto> getUsersPage(@PageableDefault Pageable pageable) {
        return userService.getUsersPage(pageable);
    }
}
