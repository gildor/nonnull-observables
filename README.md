# NonNullObsevables for Data Binding Library

This small library provides non-null implementations of [ObservableField](https://developer.android.com/reference/android/databinding/ObservableField.html) for [Data Binding Library](https://developer.android.com/topic/libraries/data-binding/index.html)

## Gradle

Library available on [JCenter](https://bintray.com/gildor/maven/NonNullObservables):

```
implementation("ru.gildor.databinding:nonnull-observables:3.2.0")
```

if you use AndroidX version of data binding library:

```
implementation("ru.gildor.databinding:nonnull-observables:3.2.0-androidx")
```

## Rationale

Data Binding ObservableField implementation is not non-null safe,
you can set null to ObservableField and default value of the field is also null.
So [ObservableField.get()](https://developer.android.com/reference/android/databinding/ObservableField.html#get())
always returns nullable value and this can cause NPE errors
or unexpected behaviour.

To notify library consumer about this Data Binding Library starting from version 3.1.0 uses
`@Nullable` annotation for [ObservableField.get()](https://developer.android.com/reference/android/databinding/ObservableField.html#get()) method.

This makes usage of this API safe but tedious, especially from Kotlin.

In many cases you don't want to use nullable value for ObservableField,
especially for `ObservableField<String>` as type with good default value (empty string)
and most widely used non-primitive observable type.

So this library created to provide non-null `ObservableField` implementations

## Implementation details

This library is pure Java Android library,
so can be used from Java or Kotlin without additional dependencies,
but because all getters, setters and constructors annotated with
`@NonNull` annotation, so it makes it pleasant and safe to use from Kotlin.

Because library written in Java you can use nullable generic type from Kotlin side,
but this doesn't allow to pass nulls to getters or setters

All getters, setters and constructors also check nullability
and throw NullPointerException exception in case of null.

Main idea: fail fast and do not propagate nulls to other parts of your code

## Versioning

Library uses the same version as Data Binding Library + suffix for possible beta versions or bug fix releases.
Please check [CHANGELOG](CHANGELOG.md) to get existing versions and release notes.

Minimal required Data Binding Library and Android Gradle Plugin version is equal to version of this library.


## Existing observable fields

[NonNullObservable](src/main/java/ru/gildor/databinding/observables/NonNullObservable.java) - non-null version of [ObservableField](https://developer.android.com/reference/android/databinding/ObservableField.html).
You must specify non-null default value to create a field

[NonNullObservableParcelable](src/main/java/ru/gildor/databinding/observables/NonNullObservableParcelable.java) - Parcelable version of `NonNullObservable`

[ObservableString](src/main/java/ru/gildor/databinding/observables/ObservableString) - non-null `ObservableField<String>` with empty string as default value
so it make it easy to use than `NonNullObservable`.

[ObservableCharSequence](src/main/java/ru/gildor/databinding/observables/ObservableCharSequence) - Observable field not only for strings, but also for any CharSequnce implementations: StringBuilder, Spannable, Editable etc.
Default value is empty string