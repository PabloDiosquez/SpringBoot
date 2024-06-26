package com.demo.spring_security_client.event;

import com.demo.spring_security_client.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Builder
@Getter @Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private UserEntity user;
    private String applicationUrl;
    public RegistrationCompleteEvent(UserEntity user, String applicationUrl){
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
