package gsm.gsmkotlin.domain.user.entity

import gsm.gsmkotlin.domain.cam.entity.Cam
import gsm.gsmkotlin.domain.user.type.Authority
import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val id: Long = 0,

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(100)")
    val email: String,

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    val name: String,
    
    @JoinColumn(name = "cam_id", nullable = false, unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    val cam: Cam,

    @Enumerated(EnumType.STRING)
    @Column(name = "authority", nullable = false)
    val authority: Authority = Authority.USER
)
