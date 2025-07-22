// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.errors

import sa.hudhud.api.core.JsonValue
import sa.hudhud.api.core.http.Headers

abstract class HudhudSdksServiceException
protected constructor(message: String, cause: Throwable? = null) :
    HudhudSdksException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
