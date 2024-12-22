package gsm.gsmkotlin.global.security.jwt

import gsm.gsmkotlin.global.security.jwt.dto.TokenDto
import gsm.gsmkotlin.global.security.jwt.properties.JwtEnvironment
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.security.Key
import java.util.*

@Component
class TokenGenerator(
    private val jwtEnv: JwtEnvironment
) {
    
    private final val TOKEN_TYPE = "tokenType"
    private final val ACCESS_TOKEN = "accessToken"
    
    fun generateToken(userId: String): TokenDto =
        TokenDto(
            accessToken = generateAccessToken(userId),
            accessTokenExp = jwtEnv.accessExp,
        )
    
    private fun generateAccessToken(userId: String): String =
        Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(jwtEnv.accessSecret.toByteArray(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
            .setSubject(userId)
            .claim(TOKEN_TYPE, ACCESS_TOKEN)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtEnv.accessExp * 1000))
            .compact()
    
    companion object {
        fun getTokenBody(token: String, secret: Key): Claims {
            return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .body
        }
    }
}
