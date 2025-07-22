// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import sa.hudhud.api.core.ClientOptions
import sa.hudhud.api.core.RequestOptions
import sa.hudhud.api.core.http.HttpResponseFor
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixParams
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixResponse

interface RoutingService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RoutingService

    /** Return a distance matrix for sources and destinations */
    fun createDistanceMatrix(
        params: RoutingCreateDistanceMatrixParams = RoutingCreateDistanceMatrixParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoutingCreateDistanceMatrixResponse

    /** @see [createDistanceMatrix] */
    fun createDistanceMatrix(requestOptions: RequestOptions): RoutingCreateDistanceMatrixResponse =
        createDistanceMatrix(RoutingCreateDistanceMatrixParams.none(), requestOptions)

    /** A view of [RoutingService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RoutingService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/routing/matrix`, but is otherwise the same as
         * [RoutingService.createDistanceMatrix].
         */
        @MustBeClosed
        fun createDistanceMatrix(
            params: RoutingCreateDistanceMatrixParams = RoutingCreateDistanceMatrixParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoutingCreateDistanceMatrixResponse>

        /** @see [createDistanceMatrix] */
        @MustBeClosed
        fun createDistanceMatrix(
            requestOptions: RequestOptions
        ): HttpResponseFor<RoutingCreateDistanceMatrixResponse> =
            createDistanceMatrix(RoutingCreateDistanceMatrixParams.none(), requestOptions)
    }
}
