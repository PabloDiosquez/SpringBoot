package com.demo.spring_security_client.event.listener;

import com.demo.spring_security_client.entity.UserEntity;
import com.demo.spring_security_client.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification Token for the User with link.
        UserEntity user = event.getUser();
        String token = UUID.randomUUID().toString();




        // Send email to user.
    }
}
