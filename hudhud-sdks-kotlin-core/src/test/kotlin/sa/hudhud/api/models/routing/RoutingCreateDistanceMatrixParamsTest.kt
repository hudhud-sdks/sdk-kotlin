// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.models.routing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoutingCreateDistanceMatrixParamsTest {

    @Test
    fun create() {
        RoutingCreateDistanceMatrixParams.builder()
            .addCoordinate(
                RoutingCreateDistanceMatrixParams.Coordinate.builder().lat(0.0).lon(0.0).build()
            )
            .addDestination(0L)
            .addSource(0L)
            .build()
    }

    @Test
    fun body() {
        val params =
            RoutingCreateDistanceMatrixParams.builder()
                .addCoordinate(
                    RoutingCreateDistanceMatrixParams.Coordinate.builder().lat(0.0).lon(0.0).build()
                )
                .addDestination(0L)
                .addSource(0L)
                .build()

        val body = params._body()

        assertThat(body.coordinates())
            .containsExactly(
                RoutingCreateDistanceMatrixParams.Coordinate.builder().lat(0.0).lon(0.0).build()
            )
        assertThat(body.destinations()).containsExactly(0L)
        assertThat(body.sources()).containsExactly(0L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = RoutingCreateDistanceMatrixParams.builder().build()

        val body = params._body()
    }
}
