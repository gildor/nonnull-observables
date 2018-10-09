package ru.gildor.databinding.observables;

import androidx.databinding.Observable;
import androidx.annotation.NonNull;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ObservableCharSequence extends NonNullObservable<CharSequence> {
    public ObservableCharSequence() {
        super("");
    }

    public ObservableCharSequence(@NonNull CharSequence value) {
        super(value);
    }

    public ObservableCharSequence(Observable... dependencies) {
        super("", dependencies);
    }

    public ObservableCharSequence(@NonNull CharSequence value, Observable... dependencies) {
        super(value, dependencies);
    }
}
