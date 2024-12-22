package gsm.gsmkotlin.domain.user.application.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

data class SignupDto(
    @NotBlank
    val accessToken: String,
    @NotBlank
    val name: String,
    @NotBlank
    val camId: String,
    @NotNull
    val emergencyNumbers: Set<String>
)

data class LoginDto(
    @NotBlank
    val accessToken: String
)

data class UserInfoDto(
    val name: String,
    val email: String,
    val driveCount: Int,
    val drives: List<DriveDetailDto>
)

data class DriveDetailDto(
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val date: LocalDateTime,
    val detectionCount: Int,
    val detectionInfo: DetectionDetailDto
)

data class DetectionDetailDto(
    val exit: Int,
    val almostSleep: Int,
    val sleeping: Int
)
