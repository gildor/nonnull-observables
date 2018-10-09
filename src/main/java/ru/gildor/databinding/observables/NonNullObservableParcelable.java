package ru.gildor.databinding.observables;

import androidx.databinding.ObservableParcelable;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import static ru.gildor.databinding.observables.CheckUtils.checkNotNull;

@SuppressWarnings({"unused", "WeakerAccess"})
public class NonNullObservableParcelable<T extends Parcelable> extends ObservableParcelable<T> {
    public NonNullObservableParcelable(@NonNull T value) {
        super(value);
        checkNotNull(value, "Default value of NonNullObservableParcelable must be non-null");
    }

    @Override
    @NonNull
    public T get() {
        T value = super.get();
        checkNotNull(value, "Value of property " + this + " is null. Null safety is broken");
        return value;
    }

    @Override
    public void set(@NonNull T value) {
        checkNotNull(value, "You cannot set null as value to NonNullObservableParcelable");
        super.set(value);
    }
}
