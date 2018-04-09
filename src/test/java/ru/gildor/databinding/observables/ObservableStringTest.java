package ru.gildor.databinding.observables;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableInt;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ObservableStringTest {
    @Test
    public void defaultIsEmptyString() {
        Assert.assertEquals("", new ObservableString().get());
    }

    @Test
    public void defaultIsEmptyStringWithDependencies() {
        ObservableString field = new ObservableString(new ObservableInt());
        assertEquals("", field.get());
    }

    @Test
    public void customDefaultValue() {
        ObservableString field = new ObservableString("custom-default");
        assertEquals("custom-default", field.get());
    }

    @Test
    public void customDefaultValueWithDependencies() {
        ObservableString field = new ObservableString("custom-default", new ObservableBoolean());
        assertEquals("custom-default", field.get());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNull() {
        ObservableString field = new ObservableString();
        field.set(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNullAsDefault() {
        new ObservableString((String) null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNullAsDefaultWithDependencies() {
        new ObservableString((String) null, new ObservableInt());
    }


    @Test
    public void getAndSet() {
        ObservableString field = new ObservableString();
        assertEquals("", field.get());
        field.set("some-value");
        assertEquals("some-value", field.get());
    }

}