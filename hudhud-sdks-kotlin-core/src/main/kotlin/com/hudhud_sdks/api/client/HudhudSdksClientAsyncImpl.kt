// File generated from our OpenAPI spec by Stainless.

package com.hudhud_sdks.api.client

import com.hudhud_sdks.api.core.ClientOptions
import com.hudhud_sdks.api.core.getPackageVersion
import com.hudhud_sdks.api.services.async.RoutingServiceAsync
import com.hudhud_sdks.api.services.async.RoutingServiceAsyncImpl

class HudhudSdksClientAsyncImpl(private val clientOptions: ClientOptions) : HudhudSdksClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: HudhudSdksClient by lazy { HudhudSdksClientImpl(clientOptions) }

    private val withRawResponse: HudhudSdksClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val routing: RoutingServiceAsync by lazy {
        RoutingServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): HudhudSdksClient = sync

    override fun withRawResponse(): HudhudSdksClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): HudhudSdksClientAsync =
        HudhudSdksClientAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun routing(): RoutingServiceAsync = routing

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        HudhudSdksClientAsync.WithRawResponse {

        private val routing: RoutingServiceAsync.WithRawResponse by lazy {
            RoutingServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): HudhudSdksClientAsync.WithRawResponse =
            HudhudSdksClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        override fun routing(): RoutingServiceAsync.WithRawResponse = routing
    }
}
