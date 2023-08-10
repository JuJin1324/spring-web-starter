package starter.springweb.web.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/08/10
 */

@AllArgsConstructor
@Getter
public enum Sorts {
    ASCENDING("ASC"), DESCENDING("DESC");

    private final String value;

    public static Sorts getMatchingSorts(String value) {
        if (Sorts.DESCENDING.getValue().equals(value.toUpperCase())) {
            return Sorts.DESCENDING;
        } else {
            return Sorts.ASCENDING;
        }
    }
}
