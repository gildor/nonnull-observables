package ru.gildor.databinding.nonnull;

import android.support.annotation.NonNull;

class CheckUtils {
    static <T> T checkNotNull(@NonNull T value) {
        //noinspection ConstantConditions
        if (value == null) {
            throw new NullPointerException();
        }
        return value;
    }

    static <T> T checkNotNull(@NonNull T value, String message) {
        //noinspection ConstantConditions
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }
}
