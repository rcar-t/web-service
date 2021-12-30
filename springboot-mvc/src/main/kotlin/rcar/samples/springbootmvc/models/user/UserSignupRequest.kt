package kotlin.rcar.samples.springbootmvc.models.user

data class UserSignupRequest(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
