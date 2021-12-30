package kotlin.rcar.samples.springbootmvc.services

import org.springframework.stereotype.Service
import kotlin.rcar.samples.springbootmvc.models.user.User

@Service
class UserService: IUserService {
    override fun signup(user: User): User = user
}