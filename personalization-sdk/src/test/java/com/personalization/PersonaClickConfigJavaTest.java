package com.personalization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Java callers see only the constructors the compiler emits. The seven-argument one is what hosts
 * wrote against 2.38; it has to keep compiling as the config grows, and the parameter added since
 * then must take its default.
 */
public class PersonaClickConfigJavaTest {

    @Test
    public void theSevenArgumentConstructorStillCompiles() {
        PersonaClickConfig config = new PersonaClickConfig("shop", "api.personaclick.com", "android", true, false, true, "SDK");

        assertEquals("shop", config.getShopId());
        assertTrue(config.getEnableAutoPopupPresentation());
    }

    @Test
    public void trailingDefaultsMayBeLeftOut() {
        PersonaClickConfig config = new PersonaClickConfig("shop");

        assertEquals("api.personaclick.com", config.getApiDomain());
        assertEquals("SDK", config.getTag());
    }
}
