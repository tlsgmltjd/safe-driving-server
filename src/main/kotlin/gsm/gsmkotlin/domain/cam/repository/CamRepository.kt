package gsm.gsmkotlin.domain.cam.repository

import gsm.gsmkotlin.domain.cam.entity.Cam
import org.springframework.data.jpa.repository.JpaRepository

interface CamRepository: JpaRepository<Cam, String> {
}
