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
import sa.hudhud.api.core.checkRequired
import sa.hudhud.api.errors.HudhudSdksInvalidDataException

class MatrixItem
private constructor(
    private val distance: JsonField<Double>,
    private val location: JsonField<Location>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("distance") @ExcludeMissing distance: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("location") @ExcludeMissing location: JsonField<Location> = JsonMissing.of(),
    ) : this(distance, location, mutableMapOf())

    /**
     * Distance between the input location and the nearest matched location for this item
     *
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun distance(): Double? = distance.getNullable("distance")

    /**
     * Location of the nearest matched point, which can be different from the input location This
     * happens when the engine tries to find the nearest routable point
     *
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun location(): Location? = location.getNullable("location")

    /**
     * Returns the raw JSON value of [distance].
     *
     * Unlike [distance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("distance") @ExcludeMissing fun _distance(): JsonField<Double> = distance

    /**
     * Returns the raw JSON value of [location].
     *
     * Unlike [location], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<Location> = location

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

        /** Returns a mutable builder for constructing an instance of [MatrixItem]. */
        fun builder() = Builder()
    }

    /** A builder for [MatrixItem]. */
    class Builder internal constructor() {

        private var distance: JsonField<Double> = JsonMissing.of()
        private var location: JsonField<Location> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(matrixItem: MatrixItem) = apply {
            distance = matrixItem.distance
            location = matrixItem.location
            additionalProperties = matrixItem.additionalProperties.toMutableMap()
        }

        /** Distance between the input location and the nearest matched location for this item */
        fun distance(distance: Double) = distance(JsonField.of(distance))

        /**
         * Sets [Builder.distance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.distance] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun distance(distance: JsonField<Double>) = apply { this.distance = distance }

        /**
         * Location of the nearest matched point, which can be different from the input location
         * This happens when the engine tries to find the nearest routable point
         */
        fun location(location: Location) = location(JsonField.of(location))

        /**
         * Sets [Builder.location] to an arbitrary JSON value.
         *
         * You should usually call [Builder.location] with a well-typed [Location] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun location(location: JsonField<Location>) = apply { this.location = location }

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
         * Returns an immutable instance of [MatrixItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MatrixItem =
            MatrixItem(distance, location, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): MatrixItem = apply {
        if (validated) {
            return@apply
        }

        distance()
        location()?.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    internal fun validity(): Int =
        (if (distance.asKnown() == null) 0 else 1) + (location.asKnown()?.validity() ?: 0)

    /**
     * Location of the nearest matched point, which can be different from the input location This
     * happens when the engine tries to find the nearest routable point
     */
    class Location
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
             * Returns a mutable builder for constructing an instance of [Location].
             *
             * The following fields are required:
             * ```kotlin
             * .lat()
             * .lon()
             * ```
             */
            fun builder() = Builder()
        }

        /** A builder for [Location]. */
        class Builder internal constructor() {

            private var lat: JsonField<Double>? = null
            private var lon: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(location: Location) = apply {
                lat = location.lat
                lon = location.lon
                additionalProperties = location.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Location].
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
            fun build(): Location =
                Location(
                    checkRequired("lat", lat),
                    checkRequired("lon", lon),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Location = apply {
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

            return /* spotless:off */ other is Location && lat == other.lat && lon == other.lon && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(lat, lon, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Location{lat=$lat, lon=$lon, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MatrixItem && distance == other.distance && location == other.location && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(distance, location, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MatrixItem{distance=$distance, location=$location, additionalProperties=$additionalProperties}"
}
