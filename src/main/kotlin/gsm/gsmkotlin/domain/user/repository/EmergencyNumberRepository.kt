package gsm.gsmkotlin.domain.user.repository

import gsm.gsmkotlin.domain.user.entity.EmergencyNumber
import org.springframework.data.jpa.repository.JpaRepository

interface EmergencyNumberRepository: JpaRepository<EmergencyNumber, Long> {
}
