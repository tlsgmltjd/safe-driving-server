package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import gsm.gsmkotlin.global.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DriveServiceImpl(
    private val userUtil: UserUtil,
    private val driveValidator: DriveValidator,
    private val driveProcessor: DriveProcessor,
    private val driveMapper: DriveMapper
) : DriveService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun start(): DriveStartDto {
        val user = userUtil.getCurrentUser()
        driveValidator.validIsNotActive(user)
        val drive = driveProcessor.start(user)
        return driveMapper.mappingDriveStart(drive)
    }
    
}
