package kotlin.rcar.samples.springbootmvc.data

data class UserSignupRequest(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
