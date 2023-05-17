package starter.springweb.external.client.apppush;


import java.util.List;

/**
 * Created by Yoo Ju Jin(jujin@100fac.com)
 * Created Date : 2023/05/17
 * Copyright (C) 2023, Centum Factorial all rights reserved.
 */
public interface AppPushClient {
    void sendData(List<String> pushTokens, PushData data);

    void sendNotification(List<String> pushTokens, PushNotification notification);

    void sendNotification(List<String> pushTokens, PushNotification notification, PushData data);
}
