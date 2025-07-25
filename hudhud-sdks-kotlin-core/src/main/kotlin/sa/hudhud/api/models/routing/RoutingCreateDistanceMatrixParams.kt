// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.models.routing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import sa.hudhud.api.core.ExcludeMissing
import sa.hudhud.api.core.JsonField
import sa.hudhud.api.core.JsonMissing
import sa.hudhud.api.core.JsonValue
import sa.hudhud.api.core.Params
import sa.hudhud.api.core.checkKnown
import sa.hudhud.api.core.checkRequired
import sa.hudhud.api.core.http.Headers
import sa.hudhud.api.core.http.QueryParams
import sa.hudhud.api.core.toImmutable
import sa.hudhud.api.errors.HudhudSdksInvalidDataException

/** Return a distance matrix for sources and destinations */
class RoutingCreateDistanceMatrixParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun coordinates(): List<Coordinate>? = body.coordinates()

    /**
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun destinations(): List<Long>? = body.destinations()

    /**
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sources(): List<Long>? = body.sources()

    /**
     * Returns the raw JSON value of [coordinates].
     *
     * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _coordinates(): JsonField<List<Coordinate>> = body._coordinates()

    /**
     * Returns the raw JSON value of [destinations].
     *
     * Unlike [destinations], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _destinations(): JsonField<List<Long>> = body._destinations()

    /**
     * Returns the raw JSON value of [sources].
     *
     * Unlike [sources], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _sources(): JsonField<List<Long>> = body._sources()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        fun none(): RoutingCreateDistanceMatrixParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [RoutingCreateDistanceMatrixParams].
         */
        fun builder() = Builder()
    }

    /** A builder for [RoutingCreateDistanceMatrixParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        internal fun from(routingCreateDistanceMatrixParams: RoutingCreateDistanceMatrixParams) =
            apply {
                body = routingCreateDistanceMatrixParams.body.toBuilder()
                additionalHeaders = routingCreateDistanceMatrixParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    routingCreateDistanceMatrixParams.additionalQueryParams.toBuilder()
            }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [coordinates]
         * - [destinations]
         * - [sources]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun coordinates(coordinates: List<Coordinate>) = apply { body.coordinates(coordinates) }

        /**
         * Sets [Builder.coordinates] to an arbitrary JSON value.
         *
         * You should usually call [Builder.coordinates] with a well-typed `List<Coordinate>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun coordinates(coordinates: JsonField<List<Coordinate>>) = apply {
            body.coordinates(coordinates)
        }

        /**
         * Adds a single [Coordinate] to [coordinates].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCoordinate(coordinate: Coordinate) = apply { body.addCoordinate(coordinate) }

        fun destinations(destinations: List<Long>) = apply { body.destinations(destinations) }

        /**
         * Sets [Builder.destinations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.destinations] with a well-typed `List<Long>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun destinations(destinations: JsonField<List<Long>>) = apply {
            body.destinations(destinations)
        }

        /**
         * Adds a single [Long] to [destinations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDestination(destination: Long) = apply { body.addDestination(destination) }

        fun sources(sources: List<Long>) = apply { body.sources(sources) }

        /**
         * Sets [Builder.sources] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sources] with a well-typed `List<Long>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun sources(sources: JsonField<List<Long>>) = apply { body.sources(sources) }

        /**
         * Adds a single [Long] to [sources].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSource(source: Long) = apply { body.addSource(source) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [RoutingCreateDistanceMatrixParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RoutingCreateDistanceMatrixParams =
            RoutingCreateDistanceMatrixParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val coordinates: JsonField<List<Coordinate>>,
        private val destinations: JsonField<List<Long>>,
        private val sources: JsonField<List<Long>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("coordinates")
            @ExcludeMissing
            coordinates: JsonField<List<Coordinate>> = JsonMissing.of(),
            @JsonProperty("destinations")
            @ExcludeMissing
            destinations: JsonField<List<Long>> = JsonMissing.of(),
            @JsonProperty("sources")
            @ExcludeMissing
            sources: JsonField<List<Long>> = JsonMissing.of(),
        ) : this(coordinates, destinations, sources, mutableMapOf())

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun coordinates(): List<Coordinate>? = coordinates.getNullable("coordinates")

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun destinations(): List<Long>? = destinations.getNullable("destinations")

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sources(): List<Long>? = sources.getNullable("sources")

        /**
         * Returns the raw JSON value of [coordinates].
         *
         * Unlike [coordinates], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("coordinates")
        @ExcludeMissing
        fun _coordinates(): JsonField<List<Coordinate>> = coordinates

        /**
         * Returns the raw JSON value of [destinations].
         *
         * Unlike [destinations], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("destinations")
        @ExcludeMissing
        fun _destinations(): JsonField<List<Long>> = destinations

        /**
         * Returns the raw JSON value of [sources].
         *
         * Unlike [sources], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sources") @ExcludeMissing fun _sources(): JsonField<List<Long>> = sources

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var coordinates: JsonField<MutableList<Coordinate>>? = null
            private var destinations: JsonField<MutableList<Long>>? = null
            private var sources: JsonField<MutableList<Long>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(body: Body) = apply {
                coordinates = body.coordinates.map { it.toMutableList() }
                destinations = body.destinations.map { it.toMutableList() }
                sources = body.sources.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun coordinates(coordinates: List<Coordinate>) = coordinates(JsonField.of(coordinates))

            /**
             * Sets [Builder.coordinates] to an arbitrary JSON value.
             *
             * You should usually call [Builder.coordinates] with a well-typed `List<Coordinate>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun coordinates(coordinates: JsonField<List<Coordinate>>) = apply {
                this.coordinates = coordinates.map { it.toMutableList() }
            }

            /**
             * Adds a single [Coordinate] to [coordinates].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCoordinate(coordinate: Coordinate) = apply {
                coordinates =
                    (coordinates ?: JsonField.of(mutableListOf())).also {
                        checkKnown("coordinates", it).add(coordinate)
                    }
            }

            fun destinations(destinations: List<Long>) = destinations(JsonField.of(destinations))

            /**
             * Sets [Builder.destinations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.destinations] with a well-typed `List<Long>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun destinations(destinations: JsonField<List<Long>>) = apply {
                this.destinations = destinations.map { it.toMutableList() }
            }

            /**
             * Adds a single [Long] to [destinations].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDestination(destination: Long) = apply {
                destinations =
                    (destinations ?: JsonField.of(mutableListOf())).also {
                        checkKnown("destinations", it).add(destination)
                    }
            }

            fun sources(sources: List<Long>) = sources(JsonField.of(sources))

            /**
             * Sets [Builder.sources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sources] with a well-typed `List<Long>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sources(sources: JsonField<List<Long>>) = apply {
                this.sources = sources.map { it.toMutableList() }
            }

            /**
             * Adds a single [Long] to [sources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSource(source: Long) = apply {
                sources =
                    (sources ?: JsonField.of(mutableListOf())).also {
                        checkKnown("sources", it).add(source)
                    }
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    (coordinates ?: JsonMissing.of()).map { it.toImmutable() },
                    (destinations ?: JsonMissing.of()).map { it.toImmutable() },
                    (sources ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            coordinates()?.forEach { it.validate() }
            destinations()
            sources()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: HudhudSdksInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            (coordinates.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
                (destinations.asKnown()?.size ?: 0) +
                (sources.asKnown()?.size ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && coordinates == other.coordinates && destinations == other.destinations && sources == other.sources && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(coordinates, destinations, sources, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{coordinates=$coordinates, destinations=$destinations, sources=$sources, additionalProperties=$additionalProperties}"
    }

    class Coordinate
    private constructor(
        private val lat: JsonField<Double>,
        private val lon: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("lat") @ExcludeMissing lat: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("lon") @ExcludeMissing lon: JsonField<Double> = JsonMissing.of(),
        ) : this(lat, lon, mutableMapOf())

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lat(): Double = lat.getRequired("lat")

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun lon(): Double = lon.getRequired("lon")

        /**
         * Returns the raw JSON value of [lat].
         *
         * Unlike [lat], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lat") @ExcludeMissing fun _lat(): JsonField<Double> = lat

        /**
         * Returns the raw JSON value of [lon].
         *
         * Unlike [lon], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("lon") @ExcludeMissing fun _lon(): JsonField<Double> = lon

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Coordinate].
             *
             * The following fields are required:
             * ```kotlin
             * .lat()
             * .lon()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [Coordinate]. */
        class Builder internal constructor() {

            private var lat: JsonField<Double>? = null
            private var lon: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(coordinate: Coordinate) = apply {
                lat = coordinate.lat
                lon = coordinate.lon
                additionalProperties = coordinate.additionalProperties.toMutableMap()
            }

            fun lat(lat: Double) = lat(JsonField.of(lat))

            /**
             * Sets [Builder.lat] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lat] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun lat(lat: JsonField<Double>) = apply { this.lat = lat }

            fun lon(lon: Double) = lon(JsonField.of(lon))

            /**
             * Sets [Builder.lon] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lon] with a well-typed [Double] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun lon(lon: JsonField<Double>) = apply { this.lon = lon }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Coordinate].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```kotlin
             * .lat()
             * .lon()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Coordinate =
                Coordinate(
                    checkRequired("lat", lat),
                    checkRequired("lon", lon),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Coordinate = apply {
            if (validated) {
                return@apply
            }

            lat()
            lon()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: HudhudSdksInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        internal fun validity(): Int =
            (if (lat.asKnown() == null) 0 else 1) + (if (lon.asKnown() == null) 0 else 1)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Coordinate && lat == other.lat && lon == other.lon && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(lat, lon, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Coordinate{lat=$lat, lon=$lon, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RoutingCreateDistanceMatrixParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "RoutingCreateDistanceMatrixParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
