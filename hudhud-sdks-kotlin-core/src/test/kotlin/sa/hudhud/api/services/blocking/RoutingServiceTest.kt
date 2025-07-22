// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.services.blocking

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import sa.hudhud.api.TestServerExtension
import sa.hudhud.api.client.okhttp.HudhudSdksOkHttpClient
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixParams

@ExtendWith(TestServerExtension::class)
internal class RoutingServiceTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun createDistanceMatrix() {
        val client =
            HudhudSdksOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val routingService = client.routing()

        val response =
            routingService.createDistanceMatrix(
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
