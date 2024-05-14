package com.example.config;

import org.springframework.stereotype.Component;

@Component
public class Version {
    private final int major;
    private final int minor;
    private final int revision;

    public Version(int major, int minor, int revision){
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    @Override
    public String toString() {
        return String.format("Mayor: %s, Minor: %s, Revision: %s", major, minor, revision);
    }
}
