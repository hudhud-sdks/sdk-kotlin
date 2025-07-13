// File generated from our OpenAPI spec by Stainless.

package com.hudhud_sdks.api.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.hudhud_sdks.api.core.JsonMissing
import com.hudhud_sdks.api.core.JsonValue
import com.hudhud_sdks.api.core.http.HttpResponse
import com.hudhud_sdks.api.core.http.HttpResponse.Handler
import com.hudhud_sdks.api.errors.BadRequestException
import com.hudhud_sdks.api.errors.InternalServerException
import com.hudhud_sdks.api.errors.NotFoundException
import com.hudhud_sdks.api.errors.PermissionDeniedException
import com.hudhud_sdks.api.errors.RateLimitException
import com.hudhud_sdks.api.errors.UnauthorizedException
import com.hudhud_sdks.api.errors.UnexpectedStatusCodeException
import com.hudhud_sdks.api.errors.UnprocessableEntityException

internal fun errorHandler(jsonMapper: JsonMapper): Handler<JsonValue> {
    val handler = jsonHandler<JsonValue>(jsonMapper)

    return object : Handler<JsonValue> {
        override fun handle(response: HttpResponse): JsonValue =
            try {
                handler.handle(response)
            } catch (e: Exception) {
                JsonMissing.of()
            }
    }
}

internal fun <T> Handler<T>.withErrorHandler(errorHandler: Handler<JsonValue>): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            when (val statusCode = response.statusCode()) {
                in 200..299 -> this@withErrorHandler.handle(response)
                400 ->
                    throw BadRequestException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                401 ->
                    throw UnauthorizedException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                403 ->
                    throw PermissionDeniedException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                404 ->
                    throw NotFoundException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                422 ->
                    throw UnprocessableEntityException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                429 ->
                    throw RateLimitException.builder()
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                in 500..599 ->
                    throw InternalServerException.builder()
                        .statusCode(statusCode)
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
                else ->
                    throw UnexpectedStatusCodeException.builder()
                        .statusCode(statusCode)
                        .headers(response.headers())
                        .body(errorHandler.handle(response))
                        .build()
            }
    }
