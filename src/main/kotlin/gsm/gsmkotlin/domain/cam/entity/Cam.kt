package gsm.gsmkotlin.domain.cam.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tbl_cam")
class Cam(
    @Id
    val camId: String,
    @Column(nullable = false, unique = true)
    val camSecret: String
)
