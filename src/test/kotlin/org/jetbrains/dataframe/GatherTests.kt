package org.jetbrains.dataframe

import io.kotlintest.shouldBe
import org.jetbrains.dataframe.api.generateTypedCode
import org.jetbrains.dataframe.io.readJsonStr
import org.junit.Test

class GatherTests {

    //region Data Source

    val df = """
            [
                {
                    "name": "abc",
                    "normal": {
                        "c1": "a",
                        "c2": "b",
                        "c3": "c"
                    },
                    "reversed": {
                        "c1": "c",
                        "c2": "b",
                        "c3": "a"
                    },
                    "first": {
                        "c1": "c"
                    }
                },
                {
                    "name": "qw",
                    "normal": {
                        "c1": "q",
                        "c2": "w"
                    },
                    "reversed": {
                        "c1": "w",
                        "c2": "q"
                    },
                    "first": {
                        "c1": "q"
                    }
                }
            ]
        """.let {
        DataFrame.readJsonStr(it)
    }

    //endregion

    val generatedCode = df.generateTypedCode("Marker")

    //region Generated code

    @DataFrameType(isOpen = false)
    interface Marker1{
        val c1: String
        val c2: String
        val c3: String?
    }
    val DataFrameBase<Marker1>.c1: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String> @JvmName("Marker1_c1") get() = this["c1"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String>
    val DataRowBase<Marker1>.c1: String @JvmName("Marker1_c1") get() = this["c1"] as String
    val DataFrameBase<Marker1>.c2: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String> @JvmName("Marker1_c2") get() = this["c2"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String>
    val DataRowBase<Marker1>.c2: String @JvmName("Marker1_c2") get() = this["c2"] as String
    val DataFrameBase<Marker1>.c3: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String?> @JvmName("Marker1_c3") get() = this["c3"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String?>
    val DataRowBase<Marker1>.c3: String? @JvmName("Marker1_c3") get() = this["c3"] as String?
    @DataFrameType(isOpen = false)
    interface Marker2{
        val c1: String
        val c2: String
        val c3: String?
    }
    val DataFrameBase<Marker2>.c1: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String> @JvmName("Marker2_c1") get() = this["c1"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String>
    val DataRowBase<Marker2>.c1: String @JvmName("Marker2_c1") get() = this["c1"] as String
    val DataFrameBase<Marker2>.c2: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String> @JvmName("Marker2_c2") get() = this["c2"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String>
    val DataRowBase<Marker2>.c2: String @JvmName("Marker2_c2") get() = this["c2"] as String
    val DataFrameBase<Marker2>.c3: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String?> @JvmName("Marker2_c3") get() = this["c3"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String?>
    val DataRowBase<Marker2>.c3: String? @JvmName("Marker2_c3") get() = this["c3"] as String?
    @DataFrameType(isOpen = false)
    interface Marker3{
        val c1: String
    }
    val DataFrameBase<Marker3>.c1: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String> @JvmName("Marker3_c1") get() = this["c1"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String>
    val DataRowBase<Marker3>.c1: String @JvmName("Marker3_c1") get() = this["c1"] as String
    @DataFrameType
    interface Marker{
        val name: String
        val normal: DataRow<Marker1>
        val reversed: DataRow<Marker2>
        val first: DataRow<Marker3>
    }
    val DataFrameBase<Marker>.first: org.jetbrains.dataframe.api.columns.GroupedColumnBase<*> @JvmName("Marker_first") get() = this["first"] as org.jetbrains.dataframe.api.columns.GroupedColumnBase<*>
    val DataRowBase<Marker>.first: org.jetbrains.dataframe.DataRow<*> @JvmName("Marker_first") get() = this["first"] as org.jetbrains.dataframe.DataRow<*>
    val DataFrameBase<Marker>.name: org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String> @JvmName("Marker_name") get() = this["name"] as org.jetbrains.dataframe.api.columns.ColumnData<kotlin.String>
    val DataRowBase<Marker>.name: String @JvmName("Marker_name") get() = this["name"] as String
    val DataFrameBase<Marker>.normal: org.jetbrains.dataframe.api.columns.GroupedColumnBase<*> @JvmName("Marker_normal") get() = this["normal"] as org.jetbrains.dataframe.api.columns.GroupedColumnBase<*>
    val DataRowBase<Marker>.normal: org.jetbrains.dataframe.DataRow<*> @JvmName("Marker_normal") get() = this["normal"] as org.jetbrains.dataframe.DataRow<*>
    val DataFrameBase<Marker>.reversed: org.jetbrains.dataframe.api.columns.GroupedColumnBase<*> @JvmName("Marker_reversed") get() = this["reversed"] as org.jetbrains.dataframe.api.columns.GroupedColumnBase<*>
    val DataRowBase<Marker>.reversed: org.jetbrains.dataframe.DataRow<*> @JvmName("Marker_reversed") get() = this["reversed"] as org.jetbrains.dataframe.DataRow<*>

    //endregion

    val typed = df.typed<Marker>()

    @Test
    fun gather() {

        val mode by column<String>()
        val gathered = typed.gather { except(name) }.into(mode)

        val expected = typed.groupBy { name }.updateGroups {

            val cols = columns.drop(1).map { it.asGrouped() } // drop 'name' column
            val dataRows = cols.map { it[0] }

            val newDf = listOf(
                    name.withValues(MutableList(cols.size){ name[0] }, false),
                    mode.withValues(cols.map { it.name }, false),
                    column("c1", dataRows.map { it.tryGet("c1") as? String}),
                    column("c2", dataRows.map { it.tryGet("c2") as? String}),
                    column("c3", dataRows.map { it.tryGet("c3") as? String})
            ).asDataFrame<Unit>()

            newDf
        }.ungroup()

        gathered shouldBe expected
    }
}