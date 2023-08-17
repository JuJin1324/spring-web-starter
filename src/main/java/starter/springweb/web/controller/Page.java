package starter.springweb.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("count")
    private final int count;

    @JsonProperty("start_index")
    private final int startIndex;

    @JsonProperty("end_index")
    private final int endIndex;

    @JsonProperty("has_more")
    private final boolean hasMore;

    @JsonProperty("data")
    private final List<T> data;

    public static <T> Page<T> of(int count, int startIndex, int endIndex, boolean hasMore, List<T> data) {
        return new Page<>(count, startIndex, endIndex, hasMore, data);
    }
}
