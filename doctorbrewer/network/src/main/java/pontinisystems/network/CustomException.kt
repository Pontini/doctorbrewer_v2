package pontinisystems.network


sealed class CustomException : Exception() {

    class ResponseBodyError(private val body: ErrorResponse?) : CustomException() {
        override val message: String?
            get() = body!!.status_message
    }

    class SessionExpired : CustomException() {
        override val message: String?
            get() = "Sessão expirada"
    }

    class TimeOutException() : CustomException() {
        override val message: String?
            get() = "Por favor, tente novamente mais tarde"
    }

    class Network() : CustomException() {
        override val message: String?
            get() = "Por favor, tente novamente mais tarde"
    }

    class Unknown(private val e: Exception) : CustomException() {

        override val message: String?
            get() = "Por favor, tente novamente mais tarde;"
    }
}