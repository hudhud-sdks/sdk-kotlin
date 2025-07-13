// File generated from our OpenAPI spec by Stainless.

package com.hudhud_sdks.api.services.async

import com.hudhud_sdks.api.TestServerExtension
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClientAsync
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RoutingServiceAsyncTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    suspend fun createDistanceMatrix() {
        val client =
            HudhudSdksOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingServiceAsync = client.routing()

        val response =
            routingServiceAsync.createDistanceMatrix(
                RoutingCreateDistanceMatrixParams.builder()
                    .addCoordinate(
                        RoutingCreateDistanceMatrixParams.Coordinate.builder()
                            .lat(0.0)
                            .lon(0.0)
                            .build()
                    )
                    .addDestination(0L)
                    .addSource(0L)
                    .build()
            )

        response.validate()
    }
}
