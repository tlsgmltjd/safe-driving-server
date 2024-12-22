package gsm.gsmkotlin.domain.user.controller

import gsm.gsmkotlin.domain.user.application.UserService
import gsm.gsmkotlin.domain.user.application.dto.LoginDto
import gsm.gsmkotlin.domain.user.application.dto.SignupDto
import gsm.gsmkotlin.domain.user.application.dto.UserInfoDto
import gsm.gsmkotlin.global.filter.JwtReqFilter.Companion.AUTHORIZATION_HEADER
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    
    @PostMapping("/signup")
    fun signup(@RequestBody signupDto: SignupDto): ResponseEntity<Void> {
        userService.signup(signupDto)
        return ResponseEntity.ok().build()
    }
    
    @PostMapping("/login")
    fun signup(@RequestBody loginDto: LoginDto, httpServletResponse: HttpServletResponse): ResponseEntity<Void> {
        val accessToken = userService.login(loginDto)
        httpServletResponse.addHeader(AUTHORIZATION_HEADER, accessToken)
        return ResponseEntity.ok().build()
    }
    
    @GetMapping
    fun userInfo(): ResponseEntity<UserInfoDto> {
        val response = userService.info()
        return ResponseEntity.ok(response)
    }
    
}
