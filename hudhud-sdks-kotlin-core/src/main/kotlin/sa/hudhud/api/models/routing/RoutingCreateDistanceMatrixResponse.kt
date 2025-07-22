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
import sa.hudhud.api.core.checkKnown
import sa.hudhud.api.core.toImmutable
import sa.hudhud.api.errors.HudhudSdksInvalidDataException

class RoutingCreateDistanceMatrixResponse
private constructor(
    private val data: JsonField<Data>,
    private val error: JsonField<String>,
    private val ok: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
        @JsonProperty("ok") @ExcludeMissing ok: JsonField<Boolean> = JsonMissing.of(),
    ) : this(data, error, ok, mutableMapOf())

    /**
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Data? = data.getNullable("data")

    /**
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): String? = error.getNullable("error")

    /**
     * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun ok(): Boolean? = ok.getNullable("ok")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

    /**
     * Returns the raw JSON value of [ok].
     *
     * Unlike [ok], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ok") @ExcludeMissing fun _ok(): JsonField<Boolean> = ok

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
         * Returns a mutable builder for constructing an instance of
         * [RoutingCreateDistanceMatrixResponse].
         */
        fun builder() = Builder()
    }

    /** A builder for [RoutingCreateDistanceMatrixResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var error: JsonField<String> = JsonMissing.of()
        private var ok: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(
            routingCreateDistanceMatrixResponse: RoutingCreateDistanceMatrixResponse
        ) = apply {
            data = routingCreateDistanceMatrixResponse.data
            error = routingCreateDistanceMatrixResponse.error
            ok = routingCreateDistanceMatrixResponse.ok
            additionalProperties =
                routingCreateDistanceMatrixResponse.additionalProperties.toMutableMap()
        }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        fun error(error: String) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<String>) = apply { this.error = error }

        fun ok(ok: Boolean) = ok(JsonField.of(ok))

        /**
         * Sets [Builder.ok] to an arbitrary JSON value.
         *
         * You should usually call [Builder.ok] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun ok(ok: JsonField<Boolean>) = apply { this.ok = ok }

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
         * Returns an immutable instance of [RoutingCreateDistanceMatrixResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RoutingCreateDistanceMatrixResponse =
            RoutingCreateDistanceMatrixResponse(
                data,
                error,
                ok,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): RoutingCreateDistanceMatrixResponse = apply {
        if (validated) {
            return@apply
        }

        data()?.validate()
        error()
        ok()
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
        (data.asKnown()?.validity() ?: 0) +
            (if (error.asKnown() == null) 0 else 1) +
            (if (ok.asKnown() == null) 0 else 1)

    class Data
    private constructor(
        private val destinations: JsonField<List<MatrixItem>>,
        private val durations: JsonField<List<List<Double>>>,
        private val sources: JsonField<List<MatrixItem>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("destinations")
            @ExcludeMissing
            destinations: JsonField<List<MatrixItem>> = JsonMissing.of(),
            @JsonProperty("durations")
            @ExcludeMissing
            durations: JsonField<List<List<Double>>> = JsonMissing.of(),
            @JsonProperty("sources")
            @ExcludeMissing
            sources: JsonField<List<MatrixItem>> = JsonMissing.of(),
        ) : this(destinations, durations, sources, mutableMapOf())

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun destinations(): List<MatrixItem>? = destinations.getNullable("destinations")

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun durations(): List<List<Double>>? = durations.getNullable("durations")

        /**
         * @throws HudhudSdksInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun sources(): List<MatrixItem>? = sources.getNullable("sources")

        /**
         * Returns the raw JSON value of [destinations].
         *
         * Unlike [destinations], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("destinations")
        @ExcludeMissing
        fun _destinations(): JsonField<List<MatrixItem>> = destinations

        /**
         * Returns the raw JSON value of [durations].
         *
         * Unlike [durations], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("durations")
        @ExcludeMissing
        fun _durations(): JsonField<List<List<Double>>> = durations

        /**
         * Returns the raw JSON value of [sources].
         *
         * Unlike [sources], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("sources")
        @ExcludeMissing
        fun _sources(): JsonField<List<MatrixItem>> = sources

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var destinations: JsonField<MutableList<MatrixItem>>? = null
            private var durations: JsonField<MutableList<List<Double>>>? = null
            private var sources: JsonField<MutableList<MatrixItem>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(data: Data) = apply {
                destinations = data.destinations.map { it.toMutableList() }
                durations = data.durations.map { it.toMutableList() }
                sources = data.sources.map { it.toMutableList() }
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun destinations(destinations: List<MatrixItem>) =
                destinations(JsonField.of(destinations))

            /**
             * Sets [Builder.destinations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.destinations] with a well-typed `List<MatrixItem>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun destinations(destinations: JsonField<List<MatrixItem>>) = apply {
                this.destinations = destinations.map { it.toMutableList() }
            }

            /**
             * Adds a single [MatrixItem] to [destinations].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDestination(destination: MatrixItem) = apply {
                destinations =
                    (destinations ?: JsonField.of(mutableListOf())).also {
                        checkKnown("destinations", it).add(destination)
                    }
            }

            fun durations(durations: List<List<Double>>) = durations(JsonField.of(durations))

            /**
             * Sets [Builder.durations] to an arbitrary JSON value.
             *
             * You should usually call [Builder.durations] with a well-typed `List<List<Double>>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun durations(durations: JsonField<List<List<Double>>>) = apply {
                this.durations = durations.map { it.toMutableList() }
            }

            /**
             * Adds a single [List<Double>] to [durations].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDuration(duration: List<Double>) = apply {
                durations =
                    (durations ?: JsonField.of(mutableListOf())).also {
                        checkKnown("durations", it).add(duration)
                    }
            }

            fun sources(sources: List<MatrixItem>) = sources(JsonField.of(sources))

            /**
             * Sets [Builder.sources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.sources] with a well-typed `List<MatrixItem>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun sources(sources: JsonField<List<MatrixItem>>) = apply {
                this.sources = sources.map { it.toMutableList() }
            }

            /**
             * Adds a single [MatrixItem] to [sources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSource(source: MatrixItem) = apply {
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    (destinations ?: JsonMissing.of()).map { it.toImmutable() },
                    (durations ?: JsonMissing.of()).map { it.toImmutable() },
                    (sources ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            destinations()?.forEach { it.validate() }
            durations()
            sources()?.forEach { it.validate() }
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
            (destinations.asKnown()?.sumOf { it.validity().toInt() } ?: 0) +
                (durations.asKnown()?.sumOf { it.size.toInt() } ?: 0) +
                (sources.asKnown()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && destinations == other.destinations && durations == other.durations && sources == other.sources && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(destinations, durations, sources, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{destinations=$destinations, durations=$durations, sources=$sources, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RoutingCreateDistanceMatrixResponse && data == other.data && error == other.error && ok == other.ok && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, error, ok, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RoutingCreateDistanceMatrixResponse{data=$data, error=$error, ok=$ok, additionalProperties=$additionalProperties}"
}
