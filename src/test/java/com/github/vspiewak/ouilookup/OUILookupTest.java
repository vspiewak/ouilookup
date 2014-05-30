package com.github.vspiewak.ouilookup;

import junit.framework.Assert;
import org.junit.Test;

public class OUILookupTest {

    @Test
    public void should_return_Apple_when_lookup_a_macbookpro_macaddress() throws Exception {

        String manufacturer = OUILookup.ouiLookup("10:dd:b1:c9:25:d1");
        Assert.assertEquals(manufacturer, "Apple");

    }

}
