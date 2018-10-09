package ru.gildor.databinding.observables;

import androidx.databinding.Observable;
import androidx.annotation.NonNull;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ObservableString extends NonNullObservable<String> {
    public ObservableString() {
        super("");
    }

    public ObservableString(@NonNull String value) {
        super(value);
    }

    public ObservableString(Observable... dependencies) {
        super("", dependencies);
    }

    public ObservableString(@NonNull String value, Observable... dependencies) {
        super(value, dependencies);
    }
}
