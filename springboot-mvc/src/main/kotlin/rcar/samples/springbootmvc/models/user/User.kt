package kotlin.rcar.samples.springbootmvc.models.user

data class User(
    var email: String,
    var password: String,
    var firstName: String,
    var lastName: String,
    var isAdmin: Boolean,
    var roles: Collection<Roles>
) {
    constructor(userSignupRequest: UserSignupRequest) : this(
        email = userSignupRequest.email,
        password = userSignupRequest.password,
        firstName = userSignupRequest.firstName,
        lastName = userSignupRequest.lastName,
        isAdmin = false,
        roles = emptyList()
    )

    fun getFullName(): String = if (firstName.isNotEmpty()) "$firstName $lastName" else ""
}
