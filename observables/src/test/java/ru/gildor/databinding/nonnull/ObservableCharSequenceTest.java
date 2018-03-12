package ru.gildor.databinding.nonnull;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObservableCharSequenceTest {
    @Test
    public void defaultIsEmptyString() {
        assertEquals("", new ObservableCharSequence().get());
    }

    @Test
    public void defaultIsEmptyStringWithDependencies() {
        ObservableCharSequence field = new ObservableCharSequence(new ObservableInt());
        assertEquals("", field.get());
    }

    @Test
    public void customDefaultValue() {
        StringBuffer custom = new StringBuffer("buffer");
        ObservableCharSequence field = new ObservableCharSequence(custom);
        assertEquals(custom, field.get());
    }

    @Test
    public void customDefaultValueWithDependencies() {
        StringBuilder custom = new StringBuilder("custom");
        ObservableCharSequence field = new ObservableCharSequence(
                custom,
                new ObservableBoolean()
        );
        assertEquals(custom, field.get());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNull() {
        ObservableCharSequence field = new ObservableCharSequence();
        field.set(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNullAsDefault() {
        new ObservableCharSequence((CharSequence) null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNullAsDefaultWithDependencies() {
        new ObservableCharSequence((String) null, new ObservableInt());
    }

    @Test
    public void getAndSet() {
        ObservableCharSequence field = new ObservableCharSequence();
        assertEquals("", field.get());
        field.set("some-value");
        assertEquals("some-value", field.get());
        StringBuilder builder = new StringBuilder("builder");
        assertEquals(builder, field.get());
    }
}