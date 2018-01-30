package ru.gildor.databinding.nonnull;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NonNullObservableTest {

    private Object defaultValue = new Object();
    private NonNullObservable<Object> field = new NonNullObservable<>(defaultValue);

    @Test
    public void getDefault() {
        assertEquals(defaultValue, field.get());
    }

    @Test
    public void get() {
        assertEquals(defaultValue, field.get());
        Object newValue = new Object();
        field.set(newValue);
        assertEquals(newValue, field.get());
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    @Test(expected = IllegalStateException.class)
    public void getNull() {
        setNullToFieldUsingReflections(field);
        field.get();
        fail("Field should throw exception if value is null");
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void createWithNull() {
        new NonNullObservable<>(null);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void createWithNullAndDependencies() {
        new NonNullObservable<>(null, new ObservableInt());
    }

    @Test
    public void set() {
        Object newValue = new Object();
        field.set(newValue);
        assertEquals(newValue, field.get());
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setNull() {
        field.set(null);
    }

    static void setNullToFieldUsingReflections(ObservableField field) {
        // Break nullability using reflections
        try {
            Field valueField = ObservableField.class.getDeclaredField("mValue");
            valueField.setAccessible(true);
            valueField.set(field, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail();
        }
    }
}
