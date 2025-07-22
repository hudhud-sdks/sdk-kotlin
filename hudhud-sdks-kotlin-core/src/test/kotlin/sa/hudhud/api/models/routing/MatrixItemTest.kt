// File generated from our OpenAPI spec by Stainless.

package sa.hudhud.api.models.routing

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import sa.hudhud.api.core.jsonMapper

internal class MatrixItemTest {

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun create() {
        val matrixItem = MatrixItem.builder().distance(0.0).addLocation(0.0).build()

        assertThat(matrixItem.distance()).isEqualTo(0.0)
        assertThat(matrixItem.location()).containsExactly(0.0)
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val matrixItem = MatrixItem.builder().distance(0.0).addLocation(0.0).build()

        val roundtrippedMatrixItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(matrixItem),
                jacksonTypeRef<MatrixItem>(),
            )

        assertThat(roundtrippedMatrixItem).isEqualTo(matrixItem)
    }
}
