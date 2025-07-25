// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import sa.hudhud.api.core.ClientOptions
import sa.hudhud.api.core.RequestOptions
import sa.hudhud.api.core.http.HttpResponseFor
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixParams
import sa.hudhud.api.models.routing.RoutingCreateDistanceMatrixResponse

interface RoutingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): RoutingServiceAsync

    /** Return a distance matrix for sources and destinations */
    suspend fun createDistanceMatrix(
        params: RoutingCreateDistanceMatrixParams = RoutingCreateDistanceMatrixParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RoutingCreateDistanceMatrixResponse

    /** @see createDistanceMatrix */
    suspend fun createDistanceMatrix(
        requestOptions: RequestOptions
    ): RoutingCreateDistanceMatrixResponse =
        createDistanceMatrix(RoutingCreateDistanceMatrixParams.none(), requestOptions)

    /**
     * A view of [RoutingServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): RoutingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/routing/matrix`, but is otherwise the same as
         * [RoutingServiceAsync.createDistanceMatrix].
         */
        @MustBeClosed
        suspend fun createDistanceMatrix(
            params: RoutingCreateDistanceMatrixParams = RoutingCreateDistanceMatrixParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RoutingCreateDistanceMatrixResponse>

        /** @see createDistanceMatrix */
        @MustBeClosed
        suspend fun createDistanceMatrix(
            requestOptions: RequestOptions
        ): HttpResponseFor<RoutingCreateDistanceMatrixResponse> =
            createDistanceMatrix(RoutingCreateDistanceMatrixParams.none(), requestOptions)
    }
}
