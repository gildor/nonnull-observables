package ru.gildor.databinding.nonnull;

import android.databinding.Observable;
import android.support.annotation.NonNull;

@SuppressWarnings("unused")
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
