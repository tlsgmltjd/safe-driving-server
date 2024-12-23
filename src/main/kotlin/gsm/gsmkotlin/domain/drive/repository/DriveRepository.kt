package gsm.gsmkotlin.domain.drive.repository

import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.drive.entity.Drive
import gsm.gsmkotlin.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface DriveRepository: JpaRepository<Drive, Long> {
    @Query("SELECT d FROM Drive d WHERE d.user = :user AND d.isActive = false")
    fun findAllHistoryByUser(user: User): List<Drive>
    fun existByUserAndActiveIsTrue(user: User): Boolean
    fun findByUserAndActiveIsTrue(user: User): Drive?
    @Query("SELECT d FROM Drive d JOIN d.user u WHERE u.cam = :cam AND d.isActive = true")
    fun findByActiveByCam(cam: Cam): Drive?
}
