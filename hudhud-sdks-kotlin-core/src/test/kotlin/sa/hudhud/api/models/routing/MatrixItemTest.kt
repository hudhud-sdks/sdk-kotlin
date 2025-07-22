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
        val matrixItem =
            MatrixItem.builder()
                .distance(0.0)
                .location(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
                .build()

        assertThat(matrixItem.distance()).isEqualTo(0.0)
        assertThat(matrixItem.location())
            .isEqualTo(MatrixItem.Location.builder().lat(0.0).lon(0.0).build())
    }

    @Disabled("skipped: tests are disabled for the time being")
    @Test
    fun roundtrip() {
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
