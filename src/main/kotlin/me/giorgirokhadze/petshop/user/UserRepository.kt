package me.giorgirokhadze.petshop.user

import me.giorgirokhadze.petshop.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
	fun findUserByUsername(username: String): User
}