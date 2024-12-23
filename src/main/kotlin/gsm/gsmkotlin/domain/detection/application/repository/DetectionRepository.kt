package gsm.gsmkotlin.domain.detection.application.repository

import gsm.gsmkotlin.domain.detection.entity.Detection
import org.springframework.data.jpa.repository.JpaRepository

interface DetectionRepository: JpaRepository<Detection, Long> {
}
