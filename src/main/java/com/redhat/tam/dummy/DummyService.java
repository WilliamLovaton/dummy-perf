package com.redhat.tam.dummy;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DummyService {

    private long counter = 0;

    public long getCounter() {
        return ++counter;
    }

}
