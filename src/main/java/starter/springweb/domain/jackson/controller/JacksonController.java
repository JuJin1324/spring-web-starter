package starter.springweb.domain.jackson.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2023/04/13
 */

@RestController
@RequestMapping("/jackson")
public class JacksonController {

    @PostMapping("/date")
    public DateDto getUtcDate(@RequestBody DateDto dateDto) {
        ZonedDateTime createDate = dateDto.getCreateDate();
        return new DateDto(createDate.withZoneSameInstant(ZoneId.of("UTC")));
    }

    @PostMapping("/trim")
    public TrimDto getTrimStr(@RequestBody TrimDto trimDto) {
        return trimDto;
    }
}
