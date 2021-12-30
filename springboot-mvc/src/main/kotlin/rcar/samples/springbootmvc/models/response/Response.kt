package kotlin.rcar.samples.springbootmvc.models.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.lang.Exception
import java.time.Instant

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Response<T>(
    var status: Status? = null,
    var payload: T? = null,
    var errors: Any? = null,
    val metadata: Any? = null
) {
    fun badRequest(): Response<T> = Response<T>().apply { status = Status.BAD_REQUEST }
    fun ok(): Response<T> = Response<T>().apply { status = Status.OK }
    fun unauthorised(): Response<T> = Response<T>().apply { status = Status.UNAUTHORIZED }
    fun validationException(): Response<T> = Response<T>().apply { status = Status.VALIDATION_EXCEPTION }
    fun wrongCredentials(): Response<T> = Response<T>().apply { status = Status.WRONG_CREDENTIALS }
    fun accessDenied(): Response<T> = Response<T>().apply { status = Status.ACCESS_DENIED }
    fun exception(): Response<T> = Response<T>().apply { status = Status.EXCEPTION }
    fun notFound(): Response<T> = Response<T>().apply { status = Status.NOT_FOUND }
    fun duplicateEntity(): Response<T> = Response<T>().apply { status = Status.DUPLICATE_ENTITY }

    fun addErrorMsg(errorMsg: String, ex: Exception) = this.apply {
        errors = ResponseError(Instant.now().toEpochMilli(), ex.message, errorMsg)
    }
}


enum class Status {
    OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND, DUPLICATE_ENTITY
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class PageMetadata (
    val size: Int,
    val totalElements: Long,
    val totalPages: Int,
    val number: Int
)