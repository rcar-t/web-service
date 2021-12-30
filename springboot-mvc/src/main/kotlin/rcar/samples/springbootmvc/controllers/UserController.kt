package kotlin.rcar.samples.springbootmvc.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.rcar.samples.springbootmvc.models.response.Response
import kotlin.rcar.samples.springbootmvc.models.user.User
import kotlin.rcar.samples.springbootmvc.models.user.UserSignupRequest

@RestController
@RequestMapping("/api/user")
class UserController {
    @PostMapping("/signup")
    fun signup(@RequestBody userSignupRequest: UserSignupRequest): Response<User> =
        Response<User>().ok().apply { payload = User(userSignupRequest) }
}