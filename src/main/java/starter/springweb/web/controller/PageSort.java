package starter.springweb.web.controller;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */

@Getter
@ToString
public class PageSort {
    private final String key;
    private final Sorts value;

    protected PageSort(String key, Sorts value) {
        this.key = key;
        this.value = value;
    }

    public static PageSort of(String key, Sorts value) {
        return new PageSort(key, value);
    }

    public static PageSort noSort() {
        return new PageSort(null, null);
    }

    public boolean isNoSort() {
        return this.key == null && this.value == null;
    }
}
