package me.giorgirokhadze.petshop.user.model

data class UserDTO(
	val id: Long,
	var username: String,
	var email: String,
	var encodedPassword: String,
	var authorities: Set<String>
)