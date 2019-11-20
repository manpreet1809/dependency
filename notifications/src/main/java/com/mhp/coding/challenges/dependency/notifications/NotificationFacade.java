package com.mhp.coding.challenges.dependency.notifications;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.InquiryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Manpreet Kaur
 */
@Service
public class NotificationFacade implements InquiryServiceInterface {
    @Autowired
    EmailHandler emailHandler;

    @Autowired
    PushNotificationHandler pushNotificationHandler;

    @Override
    public void inquiryCreated(Inquiry inquiry) {
        emailHandler.sendEmail(inquiry);
        pushNotificationHandler.sendNotification(inquiry);
    }
}
