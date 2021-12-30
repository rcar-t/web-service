package rcar.samples.springbootmvc.repositories

import kotlin.rcar.samples.springbootmvc.models.user.User

class UserRepository: BaseRepository<User, String>() {
    override fun <S : User> save(entity: S): S {
        TODO("Not yet implemented")
    }
}