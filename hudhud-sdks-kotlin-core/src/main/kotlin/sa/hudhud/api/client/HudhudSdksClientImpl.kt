// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.client

import sa.hudhud.api.core.ClientOptions
import sa.hudhud.api.core.getPackageVersion
import sa.hudhud.api.services.blocking.RoutingService
import sa.hudhud.api.services.blocking.RoutingServiceImpl

class HudhudSdksClientImpl(private val clientOptions: ClientOptions) : HudhudSdksClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: HudhudSdksClientAsync by lazy { HudhudSdksClientAsyncImpl(clientOptions) }

    private val withRawResponse: HudhudSdksClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val routing: RoutingService by lazy { RoutingServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): HudhudSdksClientAsync = async

    override fun withRawResponse(): HudhudSdksClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): HudhudSdksClient =
        HudhudSdksClientImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun routing(): RoutingService = routing

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        HudhudSdksClient.WithRawResponse {

        private val routing: RoutingService.WithRawResponse by lazy {
            RoutingServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): HudhudSdksClient.WithRawResponse =
            HudhudSdksClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun routing(): RoutingService.WithRawResponse = routing
    }
}
