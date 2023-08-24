package starter.springweb.web.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Page<T> {
    private final int count;
    private final int startIndex;
    private final int endIndex;
    private final boolean hasMore;
    private final List<T> data;

    public static <T> Page<T> of(int count, int startIndex, int endIndex, boolean hasMore, List<T> data) {
        return new Page<>(count, startIndex, endIndex, hasMore, data);
    }
}
