// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.proguard

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import sa.hudhud.api.client.okhttp.HudhudSdksOkHttpClient
import sa.hudhud.api.core.jsonMapper
import sa.hudhud.api.models.routing.MatrixItem

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/hudhud-sdks-kotlin-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = HudhudSdksOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.routing()).isNotNull()
    }

    @Test
    fun matrixItemRoundtrip() {
        val jsonMapper = jsonMapper()
        val matrixItem =
            MatrixItem.builder()
                .distance(0.0)
                .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                .build()

        val roundtrippedMatrixItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(matrixItem),
                jacksonTypeRef<MatrixItem>(),
            )

        assertThat(roundtrippedMatrixItem).isEqualTo(matrixItem)
    }
}
