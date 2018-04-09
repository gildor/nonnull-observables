package ru.gildor.databinding.observables;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static ru.gildor.databinding.observables.CheckUtils.checkNotNull;

@SuppressWarnings("WeakerAccess")
public class NonNullObservable<T> extends ObservableField<T> {
    public NonNullObservable(@NonNull T value) {
        super(value);
        checkNotNull(value, "Default value of NonNullObservable must be non-null");
    }

    public NonNullObservable(@NonNull T value, @Nullable Observable... dependencies) {
        super(dependencies);
        set(value);
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
        checkNotNull(value, "You cannot set null as value to NonNullObservable");
        super.set(value);
    }
}
