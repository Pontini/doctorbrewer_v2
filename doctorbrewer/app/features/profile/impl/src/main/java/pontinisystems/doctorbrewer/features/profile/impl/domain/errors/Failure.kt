package pontinisystems.doctorbrewer.features.profile.impl.domain.errors

sealed class Failure:Exception(){
    open class NetworkFailure(val code:Int, override val message:String): Failure()
    open class InputInvalid(override val message:String?=""): Failure()
    open class Unknown(override val message:String): Failure()
}