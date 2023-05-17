package starter.springweb.external.client.apppush;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/17
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PushNotification {
    private String title;
    private String content;
    private String imageUrl;
}
