package com.app.weatherapp.utils


class Try<T : Any> private constructor(val value: Any) {

    companion object {
        fun <T : Any> success(value: T): Try<T> =
            Try(value)

        fun <T : Any> failure(error: Throwable): Try<T> =
            Try(Failure(error))
    }

    fun getOrNull(): T? =
        when {
            isFailure -> null
            else -> value as T
        }

    fun exceptionOrNull(): Throwable? =
        when (value) {
            is Failure -> value.error
            else -> null
        }


    val isSuccess: Boolean = this.value !is Failure

    val isFailure: Boolean = this.value is Failure

    @Suppress("UNCHECKED_CAST")
    fun materialize(onFailure: (error: Throwable) -> T): T = when (this.value) {
        is Failure -> onFailure.invoke(this.value.error)
        else -> this.value as T
    }

    @Suppress("UNCHECKED_CAST")
    fun <U : Any> map(f: (T) -> U): Try<U> = when (this.value) {
        is Failure -> failure(this.value.error)
        else -> success(f.invoke(this.value as T))
    }

    private class Failure(val error: Throwable)
}
