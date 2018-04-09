package ru.gildor.databinding.observables;

import org.junit.Assert;
import org.junit.Test;

public class CheckUtilsTest {

    @Test
    public void nonNull() {
        Assert.assertEquals("not-null", CheckUtils.checkNotNull("not-null"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void nullException() {
        CheckUtils.checkNotNull(null);
    }
}