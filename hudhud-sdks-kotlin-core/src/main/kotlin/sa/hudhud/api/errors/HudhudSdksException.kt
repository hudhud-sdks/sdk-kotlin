package sa.hudhud.api.errors

open class HudhudSdksException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
