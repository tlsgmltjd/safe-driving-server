package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.user.application.dto.LoginDto
import gsm.gsmkotlin.domain.user.application.dto.LoginResponseDto
import gsm.gsmkotlin.domain.user.application.dto.SignupDto
import gsm.gsmkotlin.domain.user.application.dto.UserInfoDto

interface UserService {
    fun login(loginDto: LoginDto): LoginResponseDto
    fun signup(signupDto: SignupDto)
    fun info(): UserInfoDto
}
