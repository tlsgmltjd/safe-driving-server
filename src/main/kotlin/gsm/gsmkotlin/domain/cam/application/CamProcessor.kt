package gsm.gsmkotlin.domain.cam.application

import gsm.gsmkotlin.domain.cam.application.dto.RegisterCamDto
import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.cam.repository.CamRepository
import org.springframework.stereotype.Component

@Component
class CamProcessor(
    private val camRepository: CamRepository
) {
    
    fun register(registerCamDto: RegisterCamDto) {
        val cam = Cam(registerCamDto.camId, registerCamDto.camSecret)
        camRepository.save(cam)
    }
    
}
