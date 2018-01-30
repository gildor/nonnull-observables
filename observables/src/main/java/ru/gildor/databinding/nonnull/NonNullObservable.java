package ru.gildor.databinding.nonnull;

import android.databinding.Observable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import static ru.gildor.databinding.nonnull.CheckUtils.checkNotNull;

@SuppressWarnings("WeakerAccess")
public class NonNullObservable<T> extends ObservableField<T> {
    public NonNullObservable(@NonNull T value) {
        super(value);
        checkNotNull(value);

    }

    public NonNullObservable(@NonNull T value, Observable... dependencies) {
        super(dependencies);
        set(value);
    }

    @Override
    @NonNull
    public T get() {
        T value = super.get();
        checkNotNull(value);
        return value;
    }

    @Override
    public void set(@NonNull T value) {
        checkNotNull(value);
        super.set(value);
    }
}
