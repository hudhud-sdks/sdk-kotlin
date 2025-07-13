# Hudhud SDKs Kotlin API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.hudhud_sdks.api/hudhud-sdks-kotlin)](https://central.sonatype.com/artifact/com.hudhud_sdks.api/hudhud-sdks-kotlin/0.0.1-alpha.0)
[![javadoc](https://javadoc.io/badge2/com.hudhud_sdks.api/hudhud-sdks-kotlin/0.0.1-alpha.0/javadoc.svg)](https://javadoc.io/doc/com.hudhud_sdks.api/hudhud-sdks-kotlin/0.0.1-alpha.0)

<!-- x-release-please-end -->

The Hudhud SDKs Kotlin SDK provides convenient access to the Hudhud SDKs REST API from applications written in Kotlin.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

KDocs are available on [javadoc.io](https://javadoc.io/doc/com.hudhud_sdks.api/hudhud-sdks-kotlin/0.0.1-alpha.0).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.hudhud_sdks.api:hudhud-sdks-kotlin:0.0.1-alpha.0")
```

### Maven

```xml
<dependency>
  <groupId>com.hudhud_sdks.api</groupId>
  <artifactId>hudhud-sdks-kotlin</artifactId>
  <version>0.0.1-alpha.0</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

// Configures using the `HUDHUD_SDKS_API_KEY` and `HUDHUD_SDKS_BASE_URL` environment variables
val client: HudhudSdksClient = HudhudSdksOkHttpClient.fromEnv()

val response: RoutingCreateDistanceMatrixResponse = client.routing().createDistanceMatrix()
```

## Client configuration

Configure the client using environment variables:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient

// Configures using the `HUDHUD_SDKS_API_KEY` and `HUDHUD_SDKS_BASE_URL` environment variables
val client: HudhudSdksClient = HudhudSdksOkHttpClient.fromEnv()
```

Or manually:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient

val client: HudhudSdksClient = HudhudSdksOkHttpClient.builder()
    .apiKey("My API Key")
    .build()
```

Or using a combination of the two approaches:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient

val client: HudhudSdksClient = HudhudSdksOkHttpClient.builder()
    // Configures using the `HUDHUD_SDKS_API_KEY` and `HUDHUD_SDKS_BASE_URL` environment variables
    .fromEnv()
    .apiKey("My API Key")
    .build()
```

See this table for the available options:

| Setter    | Environment variable   | Required | Default value              |
| --------- | ---------------------- | -------- | -------------------------- |
| `apiKey`  | `HUDHUD_SDKS_API_KEY`  | true     | -                          |
| `baseUrl` | `HUDHUD_SDKS_BASE_URL` | true     | `"https://b.hudhud.sa/v1"` |

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

### Modifying configuration

To temporarily use a modified client configuration, while reusing the same connection and thread pools, call `withOptions()` on any client or service:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient

val clientWithOptions: HudhudSdksClient = client.withOptions {
    it.baseUrl("https://example.com")
    it.maxRetries(42)
}
```

The `withOptions()` method does not affect the original client or service.

## Requests and responses

To send a request to the Hudhud SDKs API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Kotlin class.

For example, `client.routing().createDistanceMatrix(...)` should be called with an instance of `RoutingCreateDistanceMatrixParams`, and it will return an instance of `RoutingCreateDistanceMatrixResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

// Configures using the `HUDHUD_SDKS_API_KEY` and `HUDHUD_SDKS_BASE_URL` environment variables
val client: HudhudSdksClient = HudhudSdksOkHttpClient.fromEnv()

val response: RoutingCreateDistanceMatrixResponse = client.async().routing().createDistanceMatrix()
```

Or create an asynchronous client from the beginning:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClientAsync
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClientAsync
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

// Configures using the `HUDHUD_SDKS_API_KEY` and `HUDHUD_SDKS_BASE_URL` environment variables
val client: HudhudSdksClientAsync = HudhudSdksOkHttpClientAsync.fromEnv()

val response: RoutingCreateDistanceMatrixResponse = client.routing().createDistanceMatrix()
```

The asynchronous client supports the same options as the synchronous one, except most methods are [suspending](https://kotlinlang.org/docs/coroutines-guide.html).

## Raw responses

The SDK defines methods that deserialize responses into instances of Kotlin classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```kotlin
import com.hudhud_sdks.api.core.http.Headers
import com.hudhud_sdks.api.core.http.HttpResponseFor
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

val response: HttpResponseFor<RoutingCreateDistanceMatrixResponse> = client.routing().withRawResponse().createDistanceMatrix()

val statusCode: Int = response.statusCode()
val headers: Headers = response.headers()
```

You can still deserialize the response into an instance of a Kotlin class if needed:

```kotlin
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

val parsedResponse: RoutingCreateDistanceMatrixResponse = response.parse()
```

## Error handling

The SDK throws custom unchecked exception types:

- [`HudhudSdksServiceException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/HudhudSdksServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                              |
  | ------ | -------------------------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/UnexpectedStatusCodeException.kt) |

- [`HudhudSdksIoException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/HudhudSdksIoException.kt): I/O networking errors.

- [`HudhudSdksInvalidDataException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/HudhudSdksInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`HudhudSdksException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/HudhudSdksException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `HUDHUD_SDKS_LOG` environment variable to `info`:

```sh
$ export HUDHUD_SDKS_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export HUDHUD_SDKS_LOG=debug
```

## Jackson

The SDK depends on [Jackson](https://github.com/FasterXML/jackson) for JSON serialization/deserialization. It is compatible with version 2.13.4 or higher, but depends on version 2.18.2 by default.

The SDK throws an exception if it detects an incompatible Jackson version at runtime (e.g. if the default version was overridden in your Maven or Gradle config).

If the SDK threw an exception, but you're _certain_ the version is compatible, then disable the version check using the `checkJacksonVersionCompatibility` on [`HudhudSdksOkHttpClient`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClient.kt) or [`HudhudSdksOkHttpClientAsync`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClientAsync.kt).

> [!CAUTION]
> We make no guarantee that the SDK works correctly when the Jackson version check is disabled.

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a response.

To set a custom number of retries, configure the client using the `maxRetries` method:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient

val client: HudhudSdksClient = HudhudSdksOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build()
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```kotlin
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

val response: RoutingCreateDistanceMatrixResponse = client.routing().createDistanceMatrix(RequestOptions.builder().timeout(Duration.ofSeconds(30)).build())
```

Or configure the default for all method calls at the client level:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient
import java.time.Duration

val client: HudhudSdksClient = HudhudSdksOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build()
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient
import java.net.InetSocketAddress
import java.net.Proxy

val client: HudhudSdksClient = HudhudSdksOkHttpClient.builder()
    .fromEnv()
    .proxy(Proxy(
      Proxy.Type.HTTP, InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build()
```

### Custom HTTP client

The SDK consists of three artifacts:

- `hudhud-sdks-kotlin-core`
  - Contains core SDK logic
  - Does not depend on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`HudhudSdksClient`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClient.kt), [`HudhudSdksClientAsync`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientAsync.kt), [`HudhudSdksClientImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientImpl.kt), and [`HudhudSdksClientAsyncImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientAsyncImpl.kt), all of which can work with any HTTP client
- `hudhud-sdks-kotlin-client-okhttp`
  - Depends on [OkHttp](https://square.github.io/okhttp)
  - Exposes [`HudhudSdksOkHttpClient`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClient.kt) and [`HudhudSdksOkHttpClientAsync`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClientAsync.kt), which provide a way to construct [`HudhudSdksClientImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientImpl.kt) and [`HudhudSdksClientAsyncImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientAsyncImpl.kt), respectively, using OkHttp
- `hudhud-sdks-kotlin`
  - Depends on and exposes the APIs of both `hudhud-sdks-kotlin-core` and `hudhud-sdks-kotlin-client-okhttp`
  - Does not have its own logic

This structure allows replacing the SDK's default HTTP client without pulling in unnecessary dependencies.

#### Customized [`OkHttpClient`](https://square.github.io/okhttp/3.x/okhttp/okhttp3/OkHttpClient.html)

> [!TIP]
> Try the available [network options](#network-options) before replacing the default client.

To use a customized `OkHttpClient`:

1. Replace your [`hudhud-sdks-kotlin` dependency](#installation) with `hudhud-sdks-kotlin-core`
2. Copy `hudhud-sdks-kotlin-client-okhttp`'s [`OkHttpClient`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/OkHttpClient.kt) class into your code and customize it
3. Construct [`HudhudSdksClientImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientImpl.kt) or [`HudhudSdksClientAsyncImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientAsyncImpl.kt), similarly to [`HudhudSdksOkHttpClient`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClient.kt) or [`HudhudSdksOkHttpClientAsync`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClientAsync.kt), using your customized client

### Completely custom HTTP client

To use a completely custom HTTP client:

1. Replace your [`hudhud-sdks-kotlin` dependency](#installation) with `hudhud-sdks-kotlin-core`
2. Write a class that implements the [`HttpClient`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/core/http/HttpClient.kt) interface
3. Construct [`HudhudSdksClientImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientImpl.kt) or [`HudhudSdksClientAsyncImpl`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/client/HudhudSdksClientAsyncImpl.kt), similarly to [`HudhudSdksOkHttpClient`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClient.kt) or [`HudhudSdksOkHttpClientAsync`](hudhud-sdks-kotlin-client-okhttp/src/main/kotlin/com/hudhud_sdks/api/client/okhttp/HudhudSdksOkHttpClientAsync.kt), using your new client class

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```kotlin
import com.hudhud_sdks.api.core.JsonValue
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams

val params: RoutingCreateDistanceMatrixParams = RoutingCreateDistanceMatrixParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build()
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/core/Values.kt) object to its setter:

```kotlin
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams

val params: RoutingCreateDistanceMatrixParams = RoutingCreateDistanceMatrixParams.builder().build()
```

The most straightforward way to create a [`JsonValue`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/core/Values.kt) is using its `from(...)` method:

```kotlin
import com.hudhud_sdks.api.core.JsonValue

// Create primitive JSON values
val nullValue: JsonValue = JsonValue.from(null)
val booleanValue: JsonValue = JsonValue.from(true)
val numberValue: JsonValue = JsonValue.from(42)
val stringValue: JsonValue = JsonValue.from("Hello World!")

// Create a JSON array value equivalent to `["Hello", "World"]`
val arrayValue: JsonValue = JsonValue.from(listOf(
  "Hello", "World"
))

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
val objectValue: JsonValue = JsonValue.from(mapOf(
  "a" to 1, "b" to 2
))

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
val complexValue: JsonValue = JsonValue.from(mapOf(
  "a" to listOf(
    1, 2
  ), "b" to listOf(
    3, 4
  )
))
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```kotlin
import com.hudhud_sdks.api.core.JsonBoolean
import com.hudhud_sdks.api.core.JsonNull
import com.hudhud_sdks.api.core.JsonNumber
import com.hudhud_sdks.api.core.JsonValue

val additionalProperties: Map<String, JsonValue> = client.routing().createDistanceMatrix(params)._additionalProperties()
val secretPropertyValue: JsonValue = additionalProperties.get("secretProperty")

val result = when (secretPropertyValue) {
    is JsonNull -> "It's null!"
    is JsonBoolean -> "It's a boolean!"
    is JsonNumber -> "It's a number!"
    // Other types include `JsonMissing`, `JsonString`, `JsonArray`, and `JsonObject`
    else -> "It's something else!"
}
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```kotlin
import com.hudhud_sdks.api.core.JsonField
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixParams

val coordinates: JsonField<List<RoutingCreateDistanceMatrixParams.Coordinate>> = client.routing().createDistanceMatrix(params)._coordinates()

if (coordinates.isMissing()) {
  // The property is absent from the JSON response
} else if (coordinates.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  val jsonString: String? = coordinates.asString();

  // Try to deserialize into a custom type
  val myObject: MyClass = coordinates.asUnknown()!!.convert(MyClass::class.java)
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`HudhudSdksInvalidDataException`](hudhud-sdks-kotlin-core/src/main/kotlin/com/hudhud_sdks/api/errors/HudhudSdksInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```kotlin
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

val response: RoutingCreateDistanceMatrixResponse = client.routing().createDistanceMatrix(params).validate()
```

Or configure the method call to validate the response using the `responseValidation` method:

```kotlin
import com.hudhud_sdks.api.models.routing.RoutingCreateDistanceMatrixResponse

val response: RoutingCreateDistanceMatrixResponse = client.routing().createDistanceMatrix(RequestOptions.builder().responseValidation(true).build())
```

Or configure the default for all method calls at the client level:

```kotlin
import com.hudhud_sdks.api.client.HudhudSdksClient
import com.hudhud_sdks.api.client.okhttp.HudhudSdksOkHttpClient

val client: HudhudSdksClient = HudhudSdksOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build()
```

## FAQ

### Why don't you use plain `enum` classes?

Kotlin `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/hudhud-sdks/sdk-kotlin/issues) with questions, bugs, or suggestions.
