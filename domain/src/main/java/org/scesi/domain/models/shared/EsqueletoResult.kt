package org.scesi.domain.models.shared

sealed class EsqueletoResult<out S, out E> {
    data class Success<out S>(val data: S) : EsqueletoResult<S, Nothing>()
    data class Error<out E>(val error: E) : EsqueletoResult<Nothing, E>()
}