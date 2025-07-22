// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.services.async

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sa.hudhud.api.TestServerExtension
import sa.hudhud.api.client.okhttp.HudhudSdksOkHttpClientAsync
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixParams

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
