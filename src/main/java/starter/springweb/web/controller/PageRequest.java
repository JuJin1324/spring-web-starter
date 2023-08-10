package starter.springweb.web.controller;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */

@Getter
@ToString
public class PageRequest {
    public static final int DEFAULT_COUNT = 10;
    public static final int DEFAULT_START_INDEX = 0;

    private final int count;

    private final int startIndex;

    private final PageSort sortBy;

    protected PageRequest(int count, int startIndex, PageSort sortBy) {
        validateCount(count);
        validateIndex(startIndex);

        this.count = count;
        this.startIndex = startIndex;
        this.sortBy = sortBy;
    }

    public static PageRequest of(int count, int startIndex, PageSort pageSort) {
        return new PageRequest(count, startIndex, pageSort);
    }

    public static PageRequest of(int count, int startIndex) {
        return new PageRequest(count, startIndex, PageSort.noSort());
    }

    public static PageRequest getDefault() {
        return new PageRequest(DEFAULT_COUNT, DEFAULT_START_INDEX, PageSort.noSort());
    }

    private void validateCount(int count) {
        if (!(count >= 1 && count <= 100)) {
            throw new IllegalArgumentException("PageRequest.count");
        }
    }

    private void validateIndex(int startIndex) {
        if (startIndex < 0) {
            throw new IllegalArgumentException("PageRequest.startIndex");
        }
    }
}
