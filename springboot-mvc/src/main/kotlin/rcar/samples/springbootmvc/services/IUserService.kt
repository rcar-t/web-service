package kotlin.rcar.samples.springbootmvc.services

import kotlin.rcar.samples.springbootmvc.models.user.User

interface IUserService {
    fun signup(user: User): User
}