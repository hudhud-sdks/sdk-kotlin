@file:JvmName("JsonHandler")

package sa.hudhud.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import sa.hudhud.api.core.http.HttpResponse
import sa.hudhud.api.core.http.HttpResponse.Handler
import sa.hudhud.api.errors.HudhudSdksInvalidDataException

internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T {
            try {
                return jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw HudhudSdksInvalidDataException("Error reading response", e)
            }
        }
    }
