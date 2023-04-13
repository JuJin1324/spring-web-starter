package starter.springweb.domain.jackson.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/13
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DateDto {
    private ZonedDateTime createDate;
}
