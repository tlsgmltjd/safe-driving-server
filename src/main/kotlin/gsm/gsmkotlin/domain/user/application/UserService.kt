package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.user.application.dto.LoginDto
import gsm.gsmkotlin.domain.user.application.dto.SignupDto
import gsm.gsmkotlin.domain.user.application.dto.UserInfoDto

interface UserService {
    fun signup(signupDto: SignupDto)
    fun login(loginDto: LoginDto): String
    fun info(): UserInfoDto
}
