// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import sa.hudhud.api.core.jsonMapper

internal class RoutingCreateDistanceMatrixResponseTest {

    @Test
    fun create() {
        val routingCreateDistanceMatrixResponse =
            RoutingCreateDistanceMatrixResponse.builder()
                .data(
                    RoutingCreateDistanceMatrixResponse.Data.builder()
                        .addDestination(
                            MatrixItem.builder()
                                .distance(0.0)
                                .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                                .build()
                        )
                        .addDistance(listOf(0.0))
                        .addDuration(listOf(0.0))
                        .addSource(
                            MatrixItem.builder()
                                .distance(0.0)
                                .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                                .build()
                        )
                        .build()
                )
                .error("error")
                .ok(true)
                .build()

        assertThat(routingCreateDistanceMatrixResponse.data())
            .isEqualTo(
                RoutingCreateDistanceMatrixResponse.Data.builder()
                    .addDestination(
                        MatrixItem.builder()
                            .distance(0.0)
                            .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                            .build()
                    )
                    .addDistance(listOf(0.0))
                    .addDuration(listOf(0.0))
                    .addSource(
                        MatrixItem.builder()
                            .distance(0.0)
                            .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                            .build()
                    )
                    .build()
            )
        assertThat(routingCreateDistanceMatrixResponse.error()).isEqualTo("error")
        assertThat(routingCreateDistanceMatrixResponse.ok()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val routingCreateDistanceMatrixResponse =
            RoutingCreateDistanceMatrixResponse.builder()
                .data(
                    RoutingCreateDistanceMatrixResponse.Data.builder()
                        .addDestination(
                            MatrixItem.builder()
                                .distance(0.0)
                                .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                                .build()
                        )
                        .addDistance(listOf(0.0))
                        .addDuration(listOf(0.0))
                        .addSource(
                            MatrixItem.builder()
                                .distance(0.0)
                                .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                                .build()
                        )
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
