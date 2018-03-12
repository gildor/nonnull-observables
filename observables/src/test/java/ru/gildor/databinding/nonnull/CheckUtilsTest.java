package ru.gildor.databinding.nonnull;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckUtilsTest {

    @Test
    public void nonNull() {
        assertEquals("not-null", CheckUtils.checkNotNull("not-null"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void nullException() {
        CheckUtils.checkNotNull(null);
    }
}