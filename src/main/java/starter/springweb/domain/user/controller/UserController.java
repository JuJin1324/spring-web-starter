package starter.springweb.domain.user.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import starter.springweb.domain.user.dto.UserPushData;
import starter.springweb.domain.user.service.UserReadDto;
import starter.springweb.domain.user.service.UserService;
import starter.springweb.external.client.apppush.AppPushClient;
import starter.springweb.external.client.apppush.PushData;
import starter.springweb.external.client.apppush.PushNotification;

import java.util.List;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final AppPushClient appPushClient;

    @GetMapping("")
    public Page<UserReadDto> getUsersPage(@PageableDefault Pageable pageable) {
        return userService.getUsersPage(pageable);
    }

    @PostMapping("/{userId}/apppush/notification")
    public void appPushNotification(@PathVariable("userId") Long userId,
                        @RequestBody AppPushRequest request) {
        appPushClient.sendNotification(List.of("app push token"), request.getPushNotification());
    }

    @PostMapping("/{userId}/apppush/data")
    public void appPushData(@PathVariable("userId") Long userId) {
        appPushClient.sendData(List.of("app push token"), new UserPushData(userId, "name", 11));
    }

    @NoArgsConstructor
    static class AppPushRequest {
        private String title;
        private String content;
        private String imageUrl;

        @JsonIgnore
        public PushNotification getPushNotification() {
            return new PushNotification(title, content, imageUrl);
        }
    }
}
