package docs.api

import io.kotest.matchers.shouldBe
import org.jetbrains.dataframe.DataFrameBase
import org.jetbrains.dataframe.DataRow
import org.jetbrains.dataframe.DataRowBase
import org.jetbrains.dataframe.annotations.DataSchema
import org.jetbrains.dataframe.asIterable
import org.jetbrains.dataframe.asSequence
import org.jetbrains.dataframe.chunked
import org.jetbrains.dataframe.col
import org.jetbrains.dataframe.column
import org.jetbrains.dataframe.columnGroup
import org.jetbrains.dataframe.columnOf
import org.jetbrains.dataframe.dataFrameOf
import org.jetbrains.dataframe.distinct
import org.jetbrains.dataframe.distinctBy
import org.jetbrains.dataframe.distinctByExpr
import org.jetbrains.dataframe.drop
import org.jetbrains.dataframe.dropNa
import org.jetbrains.dataframe.dropNulls
import org.jetbrains.dataframe.filter
import org.jetbrains.dataframe.forEach
import org.jetbrains.dataframe.group
import org.jetbrains.dataframe.groupBy
import org.jetbrains.dataframe.impl.columns.asGroup
import org.jetbrains.dataframe.into
import org.jetbrains.dataframe.isNumber
import org.jetbrains.dataframe.mapToRows
import org.jetbrains.dataframe.named
import org.jetbrains.dataframe.nrow
import org.jetbrains.dataframe.select
import org.jetbrains.dataframe.sortBy
import org.jetbrains.dataframe.typed
import org.junit.Test

val df = dataFrameOf("firstName", "lastName", "age", "city", "weight")(
    "Alice", "Cooper", 15, "London", 54,
    "Bob", "Dylan", 45, "Dubai", 87,
    "Mark", "Antony", 20, "Moscow", null,
    "Mark", "Avrely", 40, "Milan", null,
    "Bob", "Marley", 30, "Tokyo", 68,
    "Alice", "Lindt", 20, null, 55,
    "Mark", "Petrov", 30, "Moscow", 90
).group("firstName", "lastName").into("name").typed<Person>()

@DataSchema
interface Name {
    val firstName: String
    val lastName: String
}

val DataFrameBase<Name>.firstName: org.jetbrains.dataframe.columns.DataColumn<kotlin.String> @JvmName("Person1_first") get() = this["firstName"] as org.jetbrains.dataframe.columns.DataColumn<kotlin.String>
val DataRowBase<Name>.firstName: kotlin.String @JvmName("Person1_first") get() = this["firstName"] as kotlin.String
val DataFrameBase<Name>.lastName: org.jetbrains.dataframe.columns.DataColumn<kotlin.String> @JvmName("Person1_last") get() = this["lastName"] as org.jetbrains.dataframe.columns.DataColumn<kotlin.String>
val DataRowBase<Name>.lastName: kotlin.String @JvmName("Person1_last") get() = this["lastName"] as kotlin.String

@DataSchema
interface Person {
    val age: Int
    val city: String?
    val name: DataRow<Name>
    val weight: Int?
}

val org.jetbrains.dataframe.DataFrameBase<Person>.age: org.jetbrains.dataframe.columns.ValueColumn<kotlin.Int>
    @JvmName(
        "Person_age"
    ) get() = this["age"] as org.jetbrains.dataframe.columns.ValueColumn<kotlin.Int>
val org.jetbrains.dataframe.DataRowBase<Person>.age: kotlin.Int @JvmName("Person_age") get() = this["age"] as kotlin.Int
val org.jetbrains.dataframe.DataFrameBase<Person>.city: org.jetbrains.dataframe.columns.DataColumn<kotlin.String?>
    @JvmName(
        "Person_city"
    ) get() = this["city"] as org.jetbrains.dataframe.columns.DataColumn<kotlin.String?>
val org.jetbrains.dataframe.DataRowBase<Person>.city: kotlin.String? @JvmName("Person_city") get() = this["city"] as kotlin.String?
val org.jetbrains.dataframe.DataFrameBase<Person>.name: org.jetbrains.dataframe.columns.ColumnGroup<Name> @JvmName("Person_name") get() = this["name"] as org.jetbrains.dataframe.columns.ColumnGroup<Name>
val org.jetbrains.dataframe.DataRowBase<Person>.name: org.jetbrains.dataframe.DataRow<Name> @JvmName("Person_name") get() = this["name"] as org.jetbrains.dataframe.DataRow<Name>
val org.jetbrains.dataframe.DataFrameBase<Person>.weight: org.jetbrains.dataframe.columns.DataColumn<kotlin.Int?>
    @JvmName(
        "Person_weight"
    ) get() = this["weight"] as org.jetbrains.dataframe.columns.DataColumn<kotlin.Int?>
val org.jetbrains.dataframe.DataRowBase<Person>.weight: kotlin.Int? @JvmName("Person_weight") get() = this["weight"] as kotlin.Int?

class Access {

    @Test
    fun getColumnByName_strings() {
        // SampleStart
        df["age"]
        df["name"]["firstName"]
        // SampleEnd
    }

    @Test
    fun getColumnByName_properties() {
        // SampleStart
        df.age
        df.name.lastName
        // SampleEnd
    }

    @Test
    fun getColumnByName_accessors() {
        // SampleStart
        val age by column<Int>()
        val name by columnGroup()
        val lastName by column<String>(name)

        df[age]
        df[lastName]
        // SampleEnd
    }

    @Test
    fun getColumnByIndex() {
        // SampleStart
        df.col(2)
        df.col(0).asGroup().col(1)
        // SampleEnd
    }

    @Test
    fun getColumnByCondition() {
        // SampleStart
        df.col { it.isNumber() && it.hasNulls() }
        // SampleEnd
    }

    @Test
    fun getRowByIndex() {
        // SampleStart
        df[2]
        // SampleEnd
    }

    @Test
    fun getRowByCondition_properties() {
        // SampleStart
        df.single { age == 45 }
        // SampleEnd
    }

    @Test
    fun getRowByCondition_accessors() {
        // SampleStart
        val age by column<Int>()

        df.single { age() == 45 }
        // SampleEnd
    }

    @Test
    fun getRowByCondition_strings() {
        // SampleStart
        df.single { "age"<Int>() == 45 }
        // SampleEnd
    }

    @Test
    fun getCell_strings() {
        // SampleStart
        df["age"][1]
        df[1]["age"]
        // SampleEnd
    }

    @Test
    fun getCell_properties() {
        // SampleStart
        df.age[1]
        df[1].age
        // SampleEnd
    }

    @Test
    fun getCell_accessors() {
        // SampleStart
        val age by column<String>()

        df[age][1]
        df[1][age]
        // SampleEnd
    }

    @Test
    fun getColumnsByName_strings() {
        // SampleStart
        df["age", "weight"]
        // SampleEnd
    }

    @Test
    fun getColumnsByName_properties() {
        // SampleStart
        df.select { age and weight }
        // SampleEnd
    }

    @Test
    fun getColumnsByName_accessors() {
        // SampleStart
        val age by column<Int>()
        val weight by column<Int?>()
        df[age, weight]
        df.select { age and weight }
        // SampleEnd
    }

    @Test
    fun getSeveralRows() {
        // SampleStart
        df[0, 3, 4]
        df[1..2]

        df.take(5) // first 5 rows
        df.takeLast(5) // last 5 rows
        df.drop(5) // all rows except first 5
        df.dropLast(5) // all rows except last 5
        // SampleEnd
    }

    @Test
    fun filterDrop_properties() {
        // SampleStart
        df.filter { age > 18 && name.firstName.startsWith("A") }
        df.drop { weight == null || city == null }
        // SampleEnd
    }

    @Test
    fun filterDrop_accessors() {
        // SampleStart
        val age by column<Int>()
        val name by columnGroup()
        val weight by column<Int?>()
        val city by column<String?>()
        val firstName by column<String>(name)

        df.filter { age() > 18 && firstName().startsWith("A") }
        df.drop { weight() == null || city() == null }
        // or
        df.filter { it[age] > 18 && it[firstName].startsWith("A") }
        df.drop { it[weight] == null || it[city] == null }
        // SampleEnd
    }

    @Test
    fun filterDrop_strings() {
        // SampleStart
        df.filter { "age"<Int>() > 18 && "name"["firstName"]<String>().startsWith("A") }.nrow shouldBe 1
        df.drop { it["weight"] == null || it["city"] == null }
        // SampleEnd
    }

    @Test
    fun dropNulls() {
        // SampleStart
        df.dropNulls() // remove rows with null value in any column
        df.dropNulls(whereAllNull = true) // remove rows with null values in all columns
        df.dropNulls { city } // remove rows with null value in 'city' column
        df.dropNulls { city and weight } // remove rows with null value in 'city' OR 'weight' columns
        df.dropNulls(whereAllNull = true) { city and weight } // remove rows with null value in 'city' AND 'weight' columns
        // SampleEnd
    }

    @Test
    fun dropNa() {
        // SampleStart
        df.dropNa() // remove rows containing null or Double.NaN in any column
        df.dropNa(whereAllNa = true) // remove rows with null or Double.NaN in all columns
        df.dropNa { weight } // remove rows where 'weight' is null or Double.NaN
        df.dropNa { age and weight } // remove rows where either 'age' or 'weight' is null or Double.NaN
        df.dropNa(whereAllNa = true) { age and weight } // remove rows where both 'age' and 'weight' are null or Double.NaN
        // SampleEnd
    }

    @Test
    fun byColumn_strings() {
        // SampleStart
        df["name"][0]
        df["name", "age"][3, 5, 6]
        // SampleEnd
        // TODO: df["age"][2..4]
    }

    @Test
    fun byColumn_accessors() {
        // SampleStart
        val name by column<String>()
        val age by column<Int>()
        df[name][0]
        df[name, age][3, 5, 6]
        // SampleEnd
        // TODO: df[age][2..4]
    }

    @Test
    fun byColumn_properties() {
        // SampleStart
        df.name[0]
        df.select { name and age }[3, 5, 6]
        df.age[2..4]
        // SampleEnd
    }

    @Test
    fun byRow_strings() {
        // SampleStart
        df[0]["name"]
        df[3, 5, 6]["name", "age"]
        df[3..5]["age"]
        // SampleEnd
    }

    @Test
    fun byRow_accessors() {
        // SampleStart
        val name by column<String>()
        val age by column<Int>()
        df[0][name]
        df[3, 5, 6][name, age]
        df[3..5][age]
        // SampleEnd
    }

    @Test
    fun byRow_properties() {
        // SampleStart
        df[0].name
        df[3, 5, 6].select { name and age }
        df[3..5].age
        // SampleEnd
    }

    @Test
    fun namedAndRenameCol() {
        // SampleStart
        val unnamedCol = columnOf("Alice", "Bob")
        val colRename = unnamedCol.rename("name")
        val colNamed = columnOf("Alice", "Bob") named "name"
        // SampleEnd
    }

    @Test
    fun namedColumnWithoutValues() {
        // SampleStart
        val name by column<String>()
        val col = column<String>("name")
        // SampleEnd
    }

    @Test
    fun colRefForTypedAccess() {
        val df = dataFrameOf("name")("Alice", "Bob")
        val name by column<String>()
        val col = column<String>("name")
        // SampleStart
        df.filter { it[name].startsWith("A") }
        df.sortBy { col }
        // SampleEnd
    }

    @Test
    fun iterableApi() {
        // SampleStart
        df.forEach { println(it) }
        df.take(5)
        df.drop(2)
        df.chunked(10)
        // SampleEnd
    }

    @Test
    fun asIterableOrSequence() {
        // SampleStart
        df.asIterable()
        df.asSequence()
        // SampleEnd
    }

    @Test
    fun distinct() {
        // SampleStart
        df.distinct()
        // SampleEnd
    }

    @Test
    fun distinctColumns_properties() {
        // SampleStart
        df.distinct { age and name } shouldBe df.select { age and name }.distinct()
        // SampleEnd
    }

    @Test
    fun distinctColumns_accessors() {
        // SampleStart
        val age by column<Int>()
        val name by columnGroup()
        df.distinct { age and name } shouldBe df.select { age and name }.distinct()
        // SampleEnd
    }

    @Test
    fun distinctColumns_strings() {
        // SampleStart
        df.distinct("age", "name") shouldBe df.select("age", "name").distinct()
        // SampleEnd
    }

    @Test
    fun distinctBy_properties() {
        // SampleStart
        df.distinctBy { age and name } shouldBe df.groupBy { age and name }.mapToRows { group.first() }

        df.distinctByExpr { name.firstName.take(3).lowercase() }
        // SampleEnd
    }

    @Test
    fun distinctBy_accessors() {
        // SampleStart
        val age by column<Int>()
        val name by columnGroup()
        val firstName by column<String>(name)

        df.distinctBy { age and name } shouldBe df.groupBy { age and name }.mapToRows { group.first() }

        df.distinctByExpr { firstName().take(3).lowercase() }
        // SampleEnd
    }

    @Test
    fun distinctBy_strings() {
        // SampleStart
        df.distinctBy("age", "name") shouldBe df.groupBy("age", "name").mapToRows { group.first() }

        df.distinctByExpr { "name"["firstName"]<String>().take(3).lowercase() }
        // SampleEnd
    }
}