package ru.gildor.databinding.observables;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import static ru.gildor.databinding.observables.CheckUtils.checkNotNull;

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
