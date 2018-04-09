package ru.gildor.databinding.observables;

import android.os.Parcel;
import android.os.Parcelable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.gildor.databinding.observables.NonNullObservableTest.setNullToFieldUsingReflections;

public class NonNullObservableParcelableTest {

    @Test
    public void getDefault() {
        ParcelableImpl value = new ParcelableImpl();
        NonNullObservableParcelable<ParcelableImpl> observable =
                new NonNullObservableParcelable<>(value);
        assertEquals(value, observable.get());
    }

    @Test
    public void getAndSet() {
        ParcelableImpl value = new ParcelableImpl();
        NonNullObservableParcelable<ParcelableImpl> observable =
                new NonNullObservableParcelable<>(value);
        ParcelableImpl newValue = new ParcelableImpl();
        observable.set(newValue);
        assertEquals(newValue, observable.get());
    }

    @Test(expected = NullPointerException.class)
    public void getNull() {
        ParcelableImpl value = new ParcelableImpl();
        NonNullObservableParcelable<ParcelableImpl> observable =
                new NonNullObservableParcelable<>(value);
        // Using reflection set null to value
        setNullToFieldUsingReflections(observable);
        // Check that we never return null even on get
        observable.get();
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void setDefaultNull() {
        new NonNullObservableParcelable<ParcelableImpl>(null);
    }

    class ParcelableImpl implements Parcelable {
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {

        }
    }
}