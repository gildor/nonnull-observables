package ru.gildor.databinding.nonnull;

import android.databinding.ObservableParcelable;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import static ru.gildor.databinding.nonnull.CheckUtils.checkNotNull;

@SuppressWarnings("unused")
public class NonNullObservableParcelable<T extends Parcelable> extends ObservableParcelable<T> {
    public NonNullObservableParcelable(@NonNull T value) {
        super(value);
        checkNotNull(value);
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
