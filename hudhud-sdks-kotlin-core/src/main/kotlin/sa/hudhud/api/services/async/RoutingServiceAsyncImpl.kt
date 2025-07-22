// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.services.async

import sa.hudhud.api.core.ClientOptions
import sa.hudhud.api.core.RequestOptions
import sa.hudhud.api.core.handlers.errorBodyHandler
import sa.hudhud.api.core.handlers.errorHandler
import sa.hudhud.api.core.handlers.jsonHandler
import sa.hudhud.api.core.http.HttpMethod
import sa.hudhud.api.core.http.HttpRequest
import sa.hudhud.api.core.http.HttpResponse
import sa.hudhud.api.core.http.HttpResponse.Handler
import sa.hudhud.api.core.http.HttpResponseFor
import sa.hudhud.api.core.http.json
import sa.hudhud.api.core.http.parseable
import sa.hudhud.api.core.prepareAsync
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixParams
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixResponse

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
