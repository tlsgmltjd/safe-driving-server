package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.cam.application.CamReader
import gsm.gsmkotlin.domain.user.application.dto.LoginDto
import gsm.gsmkotlin.domain.user.application.dto.SignupDto
import gsm.gsmkotlin.global.filter.JwtReqFilter.Companion.BEARER_PREFIX
import gsm.gsmkotlin.global.security.jwt.TokenGenerator
import gsm.gsmkotlin.global.thirdparty.feign.GoogleLoginFeignClientService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val googleLoginFeignClientService: GoogleLoginFeignClientService,
    private val camReader: CamReader,
    private val userReader: UserReader,
    private val userProcessor: UserProcessor,
    private val tokenGenerator: TokenGenerator
) : UserService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun signup(signupDto: SignupDto) {
        val cam = camReader.readCamById(signupDto.camId)
        val email = googleLoginFeignClientService.login(signupDto.accessToken).email
        userProcessor.signup(email, signupDto.name, cam, signupDto.emergencyNumbers)
    }
    
    @Transactional(rollbackFor = [Exception::class])
    override fun login(loginDto: LoginDto): String {
        val email = googleLoginFeignClientService.login(loginDto.accessToken).email
        val user = userReader.readUserByEmail(email)
        return BEARER_PREFIX + tokenGenerator.generateToken(user.id.toString()).accessToken
    }
    
}
