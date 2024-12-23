package gsm.gsmkotlin.domain.detection.entity

import gsm.gsmkotlin.domain.detection.type.DetectionType
import gsm.gsmkotlin.domain.drive.entity.Drive
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_detection")
class Detection(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val detectionId: Long = 0,
    @ManyToOne
    @JoinColumn(name = "drive_id")
    val drive: Drive,
    @Column(nullable = false)
    val type: DetectionType,
    @Column(nullable = false)
    val date: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun of(drive: Drive, type: DetectionType): Detection =
            Detection(drive = drive, type = type)
    }
}
