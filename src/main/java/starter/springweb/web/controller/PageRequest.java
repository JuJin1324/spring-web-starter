package starter.springweb.web.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class PageRequest {
    public static final int DEFAULT_COUNT = 10;
    public static final int DEFAULT_START_INDEX = 0;

    @Range(min = 1, max = 100)
    private final int count;

    @Min(0)
    private final int startIndex;

    private final PageSort sortBy;

    public static PageRequest of(int count, int startIndex, PageSort pageSort) {
        return new PageRequest(count, startIndex, pageSort);
    }

    public static PageRequest of(int count, int startIndex) {
        return new PageRequest(count, startIndex, PageSort.noSort());
    }

    public static PageRequest getDefault() {
        return new PageRequest(DEFAULT_COUNT, DEFAULT_START_INDEX, PageSort.noSort());
    }
}
