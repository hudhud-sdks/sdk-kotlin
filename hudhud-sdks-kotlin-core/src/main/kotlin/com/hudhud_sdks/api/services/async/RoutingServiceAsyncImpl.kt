// File generated from our OpenAPI spec by Stainless.

package com.hudhud_sdks.api.services.async

import com.hudhud_sdks.api.core.ClientOptions
import com.hudhud_sdks.api.core.RequestOptions
import com.hudhud_sdks.api.core.handlers.errorBodyHandler
import com.hudhud_sdks.api.core.handlers.errorHandler
import com.hudhud_sdks.api.core.handlers.jsonHandler
import com.hudhud_sdks.api.core.http.HttpMethod
import com.hudhud_sdks.api.core.http.HttpRequest
import com.hudhud_sdks.api.core.http.HttpResponse
import com.hudhud_sdks.api.core.http.HttpResponse.Handler
import com.hudhud_sdks.api.core.http.HttpResponseFor
import com.hudhud_sdks.api.core.http.json
import com.hudhud_sdks.api.core.http.parseable
import com.hudhud_sdks.api.core.prepareAsync
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

class RoutingServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    RoutingServiceAsync {

    private val withRawResponse: RoutingServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): RoutingServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RoutingServiceAsync =
        RoutingServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun createDistanceMatrix(
        params: RoutingCreateDistanceMatrixParams,
        requestOptions: RequestOptions,
    ): RoutingCreateDistanceMatrixResponse =
        // post /v1/routing/matrix
        withRawResponse().createDistanceMatrix(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        RoutingServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): RoutingServiceAsync.WithRawResponse =
            RoutingServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val createDistanceMatrixHandler: Handler<RoutingCreateDistanceMatrixResponse> =
            jsonHandler<RoutingCreateDistanceMatrixResponse>(clientOptions.jsonMapper)

        override suspend fun createDistanceMatrix(
            params: RoutingCreateDistanceMatrixParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RoutingCreateDistanceMatrixResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "routing", "matrix")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createDistanceMatrixHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
