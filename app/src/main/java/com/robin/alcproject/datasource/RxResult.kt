package com.robin.alcproject.datasource

import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * @author robin
 * Created on 9/9/20
 */
class RxResult<T> private constructor(
    @Nullable private val result: T?,
    @Nullable private val error: Throwable?
) {

    @Nullable
    fun getResult(): T? {
        return result
    }

    @Nullable
    fun getError(): Throwable? {
        return error
    }

    companion object {
        @NonNull
        fun <T> success(@NonNull result: T): RxResult<T> {
            return RxResult(result, null)
        }

        @NonNull
        fun <T> error(@NonNull error: Throwable): RxResult<T> {
            return RxResult<T>(null, error)
        }
    }
}