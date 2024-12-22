package gsm.gsmkotlin.global.security.jwt.dto

data class TokenDto(
    val accessToken: String,
    val accessTokenExp: Int,
)
