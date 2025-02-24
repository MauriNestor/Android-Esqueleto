package org.scesi.esqueleto.data

import org.scesi.domain.models.shared.EsqueletoResult
import org.scesi.esqueleto.network.toError

inline fun <T> tryCall(action: () -> T) = try {
    EsqueletoResult.Success(action())
} catch (e: java.lang.Exception) {
    e.message?.let { } //TODO add timber
    EsqueletoResult.Error(e.toError())
}
