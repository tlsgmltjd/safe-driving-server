package gsm.gsmkotlin.domain.cam.application

import gsm.gsmkotlin.domain.cam.application.dto.RegisterCamDto

interface CamService {
    fun register(registerCamDto: RegisterCamDto)
}
