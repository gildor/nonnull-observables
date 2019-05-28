package ru.gildor.databinding.observables;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;

@SuppressWarnings({"unused"})
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
