package org.scesi.domain.models.shared

sealed class EsqueletoError {
    class Server(val code: Int, val message: String = "") : EsqueletoError()
    object Connectivity : EsqueletoError()
    class Unknown(val message: String = "") : EsqueletoError()
}