package me.giorgirokhadze.petshop.security

import me.giorgirokhadze.petshop.security.Authority.ADMIN
import me.giorgirokhadze.petshop.security.Authority.ANONYMOUS
import me.giorgirokhadze.petshop.security.Authority.USER

object Role {
	const val ROLE_USER = "ROLE_$USER"
	const val ROLE_ADMIN = "ROLE_$ADMIN"
	const val ROLE_ANONYMOUS = "ROLE_$ANONYMOUS"
}