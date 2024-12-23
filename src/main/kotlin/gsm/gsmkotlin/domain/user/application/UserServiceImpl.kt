package gsm.gsmkotlin.domain.user.application

import gsm.gsmkotlin.domain.cam.application.CamReader
import gsm.gsmkotlin.domain.drive.application.DriveReader
import gsm.gsmkotlin.domain.user.application.dto.LoginDto
import gsm.gsmkotlin.domain.user.application.dto.LoginResponseDto
import gsm.gsmkotlin.domain.user.application.dto.SignupDto
import gsm.gsmkotlin.domain.user.application.dto.UserInfoDto
import gsm.gsmkotlin.global.filter.JwtReqFilter.Companion.BEARER_PREFIX
import gsm.gsmkotlin.global.security.jwt.TokenGenerator
import gsm.gsmkotlin.global.thirdparty.feign.GoogleLoginFeignClientService
import gsm.gsmkotlin.global.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val googleLoginFeignClientService: GoogleLoginFeignClientService,
    private val userUtil: UserUtil,
    private val camReader: CamReader,
    private val driveReader: DriveReader,
    private val userReader: UserReader,
    private val userProcessor: UserProcessor,
    private val tokenGenerator: TokenGenerator,
    private val userMapper: UserMapper
) : UserService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun login(loginDto: LoginDto): LoginResponseDto {
        val email = googleLoginFeignClientService.login(loginDto.accessToken).email
        val user = userReader.readUserByEmailOrNull(email)
            ?: userProcessor.register(email)
        val accessToken = BEARER_PREFIX + tokenGenerator.generateToken(user.id.toString()).accessToken
        return userMapper.mappingLoginResponse(user, accessToken)
    }
    
    @Transactional(rollbackFor = [Exception::class])
    override fun signup(signupDto: SignupDto) {
        val cam = camReader.readCamById(signupDto.camId)
        val email = googleLoginFeignClientService.login(signupDto.accessToken).email
        val user = userReader.readUserByEmail(email)
        userProcessor.signup(user, signupDto.name, cam, signupDto.emergencyNumbers)
    }
    
    @Transactional(readOnly = true)
    override fun info(): UserInfoDto {
        val user = userUtil.getCurrentUser()
        val driveHistory = driveReader.readAllDriveHistoryByUser(user)
        return userMapper.mappingUserInfo(user, driveHistory)
    }
    
}
