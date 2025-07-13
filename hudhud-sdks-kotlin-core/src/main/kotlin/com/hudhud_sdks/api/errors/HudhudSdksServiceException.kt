// File generated from our OpenAPI spec by Stainless.

package com.hudhud_sdks.api.errors

import com.hudhud_sdks.api.core.JsonValue
import com.hudhud_sdks.api.core.http.Headers

abstract class HudhudSdksServiceException
protected constructor(message: String, cause: Throwable? = null) :
    HudhudSdksException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
