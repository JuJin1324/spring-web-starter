package starter.springweb.domain.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/12
 */
public interface UserService {

    Page<UserReadDto> getUsersPage(Pageable pageable);

    Slice<UserReadDto> getUsersSlice(Pageable pageable);
}
