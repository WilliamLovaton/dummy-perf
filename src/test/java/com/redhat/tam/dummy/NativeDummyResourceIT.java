package com.redhat.tam.dummy;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeDummyResourceIT extends DummyResourceTest {

    // Execute the same tests but in native mode.
}