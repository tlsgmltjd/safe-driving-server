package gsm.gsmkotlin.domain.drive.application

import gsm.gsmkotlin.domain.drive.application.dto.DriveEndDto
import gsm.gsmkotlin.domain.drive.application.dto.DriveStartDto
import gsm.gsmkotlin.global.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DriveServiceImpl(
    private val userUtil: UserUtil,
    private val driveValidator: DriveValidator,
    private val driveProcessor: DriveProcessor,
    private val driveMapper: DriveMapper,
    private val driveReader: DriveReader
) : DriveService {
    
    @Transactional(rollbackFor = [Exception::class])
    override fun start(): DriveStartDto {
        val user = userUtil.getCurrentUser()
        driveValidator.validIsNotActive(user)
        val drive = driveProcessor.start(user)
        return driveMapper.mappingDriveStart(drive)
    }
    
    @Transactional(rollbackFor = [Exception::class])
    override fun end(): DriveEndDto {
        val user = userUtil.getCurrentUser()
        val drive = driveReader.readCurrentDriveByUser(user)
        driveProcessor.end(drive)
        return driveMapper.mappingDriveEnd(drive)
    }
    
}
