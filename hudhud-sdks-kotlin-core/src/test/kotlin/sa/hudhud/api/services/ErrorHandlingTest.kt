// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.services

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock
import sa.hudhud.api.client.HudhudSdksClient
import sa.hudhud.api.client.okhttp.HudhudSdksOkHttpClient
import sa.hudhud.api.core.JsonValue
import sa.hudhud.api.core.http.Headers
import sa.hudhud.api.core.jsonMapper
import sa.hudhud.api.errors.BadRequestException
import sa.hudhud.api.errors.HudhudSdksException
import sa.hudhud.api.errors.InternalServerException
import sa.hudhud.api.errors.NotFoundException
import sa.hudhud.api.errors.PermissionDeniedException
import sa.hudhud.api.errors.RateLimitException
import sa.hudhud.api.errors.UnauthorizedException
import sa.hudhud.api.errors.UnexpectedStatusCodeException
import sa.hudhud.api.errors.UnprocessableEntityException
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixParams

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: HudhudSdksClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            HudhudSdksOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun routingCreateDistanceMatrix400() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix400WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix401() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix401WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix403() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix403WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix404() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix404WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix422() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix422WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix429() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix429WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix500() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix500WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix999() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrix999WithRawResponse() {
        val routingService = client.routing().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
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
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun routingCreateDistanceMatrixInvalidJsonBody() {
        val routingService = client.routing()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<HudhudSdksException> {
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
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
