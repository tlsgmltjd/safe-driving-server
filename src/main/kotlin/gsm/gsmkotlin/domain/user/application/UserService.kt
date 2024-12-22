package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.user.application.dto.LoginDto
import gsm.gsmkotlin.domain.user.application.dto.SignupDto

interface UserService {
    fun signup(signupDto: SignupDto)
    fun login(loginDto: LoginDto): String
}
