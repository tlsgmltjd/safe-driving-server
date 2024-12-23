package gsm.gsmkotlin.domain.cam.application

import gsm.gsmkotlin.domain.cam.application.dto.RegisterCamDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CamServiceImpl(
    private val camValidator: CamValidator,
    private val camProcessor: CamProcessor
) : CamService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun register(registerCamDto: RegisterCamDto) {
        camValidator.validIsDuplicatedCamId(registerCamDto.camId)
        camProcessor.register(registerCamDto)
    }
    
}
