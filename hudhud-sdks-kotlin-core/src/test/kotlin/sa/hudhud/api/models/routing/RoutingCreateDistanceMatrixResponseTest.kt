// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import sa.hudhud.api.core.jsonMapper

internal class RoutingCreateDistanceMatrixResponseTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val routingCreateDistanceMatrixResponse =
            RoutingCreateDistanceMatrixResponse.builder()
                .data(
                    RoutingCreateDistanceMatrixResponse.Data.builder()
                        .addDestination(MatrixItem.builder().distance(0.0).addLocation(0.0).build())
                        .addDuration(listOf(0.0))
                        .addSource(MatrixItem.builder().distance(0.0).addLocation(0.0).build())
                        .build()
                )
                .error("error")
                .ok(true)
                .build()

        assertThat(routingCreateDistanceMatrixResponse.data())
            .isEqualTo(
                RoutingCreateDistanceMatrixResponse.Data.builder()
                    .addDestination(MatrixItem.builder().distance(0.0).addLocation(0.0).build())
                    .addDuration(listOf(0.0))
                    .addSource(MatrixItem.builder().distance(0.0).addLocation(0.0).build())
                    .build()
            )
        assertThat(routingCreateDistanceMatrixResponse.error()).isEqualTo("error")
        assertThat(routingCreateDistanceMatrixResponse.ok()).isEqualTo(true)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routingCreateDistanceMatrixResponse =
            RoutingCreateDistanceMatrixResponse.builder()
                .data(
                    RoutingCreateDistanceMatrixResponse.Data.builder()
                        .addDestination(MatrixItem.builder().distance(0.0).addLocation(0.0).build())
                        .addDuration(listOf(0.0))
                        .addSource(MatrixItem.builder().distance(0.0).addLocation(0.0).build())
                        .build()
                )
                .error("error")
                .ok(true)
                .build()

        val roundtrippedRoutingCreateDistanceMatrixResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(routingCreateDistanceMatrixResponse),
                jacksonTypeRef<RoutingCreateDistanceMatrixResponse>(),
            )

        assertThat(roundtrippedRoutingCreateDistanceMatrixResponse)
            .isEqualTo(routingCreateDistanceMatrixResponse)
    }
}
