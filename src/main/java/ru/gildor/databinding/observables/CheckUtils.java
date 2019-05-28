package ru.gildor.databinding.observables;

import androidx.annotation.Nullable;

class CheckUtils {
    static <T> T checkNotNull(@Nullable T value) {
        //noinspection ConstantConditions
        if (value == null) {
            throw new NullPointerException();
        }
        return value;
    }

    static <T> T checkNotNull(@Nullable T value, String message) {
        //noinspection ConstantConditions
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }
}
