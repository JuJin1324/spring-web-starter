package starter.springweb.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import starter.springweb.domain.user.repository.UserRepository;
import starter.springweb.domain.user.service.UserReadDto;
import starter.springweb.domain.user.service.UserService;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<UserReadDto> getUsersPage(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserReadDto::from);
    }

    @Override
    public Slice<UserReadDto> getUsersSlice(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserReadDto::from);
    }
}
