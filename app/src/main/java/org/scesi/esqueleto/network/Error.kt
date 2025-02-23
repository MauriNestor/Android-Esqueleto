package org.scesi.esqueleto.network

import org.scesi.domain.models.shared.EsqueletoError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toError(): EsqueletoError = when (this) {
    is IOException -> EsqueletoError.Connectivity
    is HttpException -> EsqueletoError.Server(code())
    else -> EsqueletoError.Unknown(message ?: "")
}