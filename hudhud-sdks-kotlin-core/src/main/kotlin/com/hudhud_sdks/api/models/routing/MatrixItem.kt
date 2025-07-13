// File generated from our OpenAPI spec by Stainless.

package com.hudhud_sdks.api.models.routing

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.hudhud_sdks.api.core.ExcludeMissing
import com.hudhud_sdks.api.core.JsonField
import com.hudhud_sdks.api.core.JsonMissing
import com.hudhud_sdks.api.core.JsonValue
import com.hudhud_sdks.api.core.checkKnown
import com.hudhud_sdks.api.core.toImmutable
import com.hudhud_sdks.api.errors.HudhudSdksInvalidDataException
import java.util.Collections
import java.util.Objects

class MatrixItem
private constructor(
    private val distance: JsonField<Double>,
    private val location: JsonField<List<Double>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("distance") @ExcludeMissing distance: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("location")
        @ExcludeMissing
        location: JsonField<List<Double>> = JsonMissing.of(),
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
    fun location(): List<Double>? = location.getNullable("location")

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
    @JsonProperty("location") @ExcludeMissing fun _location(): JsonField<List<Double>> = location

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
        private var location: JsonField<MutableList<Double>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(matrixItem: MatrixItem) = apply {
            distance = matrixItem.distance
            location = matrixItem.location.map { it.toMutableList() }
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
        fun location(location: List<Double>) = location(JsonField.of(location))

        /**
         * Sets [Builder.location] to an arbitrary JSON value.
         *
         * You should usually call [Builder.location] with a well-typed `List<Double>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun location(location: JsonField<List<Double>>) = apply {
            this.location = location.map { it.toMutableList() }
        }

        /**
         * Adds a single [Double] to [Builder.location].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLocation(location: Double) = apply {
            this.location =
                (this.location ?: JsonField.of(mutableListOf())).also {
                    checkKnown("location", it).add(location)
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
         * Returns an immutable instance of [MatrixItem].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): MatrixItem =
            MatrixItem(
                distance,
                (location ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MatrixItem = apply {
        if (validated) {
            return@apply
        }

        distance()
        location()
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
        (if (distance.asKnown() == null) 0 else 1) + (location.asKnown()?.size ?: 0)

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
