package kotlin.rcar.samples.springbootmvc.models.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ResponseError(
    val timestamp: Long? = null,
    val message: String? = null,
    val details: String? = null
)
