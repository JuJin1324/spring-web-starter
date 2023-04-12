package starter.springweb.domain.user.service;

import lombok.Getter;
import starter.springweb.domain.user.entity.User;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */

@Getter
public class UserReadDto {
    private Long userId;
    private String name;
    private Integer age;

    protected UserReadDto(Long userId, String name, Integer age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public static UserReadDto from(User user) {
        return new UserReadDto(user.getId(), user.getName(), user.getAge());
    }
}
