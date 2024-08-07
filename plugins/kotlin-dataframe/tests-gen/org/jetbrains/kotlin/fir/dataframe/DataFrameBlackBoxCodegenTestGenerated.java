

package org.jetbrains.kotlin.fir.dataframe;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.fir.dataframe.GenerateTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("testData/box")
@TestDataPath("$PROJECT_ROOT")
public class DataFrameBlackBoxCodegenTestGenerated extends AbstractDataFrameBlackBoxCodegenTest {
  @Test
  public void testAllFilesPresentInBox() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("testData/box"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
  }

  @Test
  @TestMetadata("castTo.kt")
  public void testCastTo() {
    runTest("testData/box/castTo.kt");
  }

  @Test
  @TestMetadata("columnGroupApi.kt")
  public void testColumnGroupApi() {
    runTest("testData/box/columnGroupApi.kt");
  }

  @Test
  @TestMetadata("columnName.kt")
  public void testColumnName() {
    runTest("testData/box/columnName.kt");
  }

  @Test
  @TestMetadata("columnWithStarProjection.kt")
  public void testColumnWithStarProjection() {
    runTest("testData/box/columnWithStarProjection.kt");
  }

  @Test
  @TestMetadata("conflictingJvmDeclarations.kt")
  public void testConflictingJvmDeclarations() {
    runTest("testData/box/conflictingJvmDeclarations.kt");
  }

  @Test
  @TestMetadata("convertToDataFrame.kt")
  public void testConvertToDataFrame() {
    runTest("testData/box/convertToDataFrame.kt");
  }

  @Test
  @TestMetadata("dataFrameOf.kt")
  public void testDataFrameOf() {
    runTest("testData/box/dataFrameOf.kt");
  }

  @Test
  @TestMetadata("dataRowSchemaApi.kt")
  public void testDataRowSchemaApi() {
    runTest("testData/box/dataRowSchemaApi.kt");
  }

  @Test
  @TestMetadata("dataSchemaCodegen.kt")
  public void testDataSchemaCodegen() {
    runTest("testData/box/dataSchemaCodegen.kt");
  }

  @Test
  @TestMetadata("dfIde.kt")
  public void testDfIde() {
    runTest("testData/box/dfIde.kt");
  }

  @Test
  @TestMetadata("diff.kt")
  public void testDiff() {
    runTest("testData/box/diff.kt");
  }

  @Test
  @TestMetadata("dropNulls.kt")
  public void testDropNulls() {
    runTest("testData/box/dropNulls.kt");
  }

  @Test
  @TestMetadata("duplicatedSignature.kt")
  public void testDuplicatedSignature() {
    runTest("testData/box/duplicatedSignature.kt");
  }

  @Test
  @TestMetadata("explode.kt")
  public void testExplode() {
    runTest("testData/box/explode.kt");
  }

  @Test
  @TestMetadata("explodeDataFrame.kt")
  public void testExplodeDataFrame() {
    runTest("testData/box/explodeDataFrame.kt");
  }

  @Test
  @TestMetadata("extractDataSchemaWithStarProjection.kt")
  public void testExtractDataSchemaWithStarProjection() {
    runTest("testData/box/extractDataSchemaWithStarProjection.kt");
  }

  @Test
  @TestMetadata("extractDataSchemaWithTypeParameter.kt")
  public void testExtractDataSchemaWithTypeParameter() {
    runTest("testData/box/extractDataSchemaWithTypeParameter.kt");
  }

  @Test
  @TestMetadata("extractPluginSchemaWithUnfold.kt")
  public void testExtractPluginSchemaWithUnfold() {
    runTest("testData/box/extractPluginSchemaWithUnfold.kt");
  }

  @Test
  @TestMetadata("flexibleReturnType.kt")
  public void testFlexibleReturnType() {
    runTest("testData/box/flexibleReturnType.kt");
  }

  @Test
  @TestMetadata("group.kt")
  public void testGroup() {
    runTest("testData/box/group.kt");
  }

  @Test
  @TestMetadata("groupBy.kt")
  public void testGroupBy() {
    runTest("testData/box/groupBy.kt");
  }

  @Test
  @TestMetadata("groupBy_DataRow.kt")
  public void testGroupBy_DataRow() {
    runTest("testData/box/groupBy_DataRow.kt");
  }

  @Test
  @TestMetadata("groupBy_toDataFrame.kt")
  public void testGroupBy_toDataFrame() {
    runTest("testData/box/groupBy_toDataFrame.kt");
  }

  @Test
  @TestMetadata("injectAccessors.kt")
  public void testInjectAccessors() {
    runTest("testData/box/injectAccessors.kt");
  }

  @Test
  @TestMetadata("injectAccessorsDsl.kt")
  public void testInjectAccessorsDsl() {
    runTest("testData/box/injectAccessorsDsl.kt");
  }

  @Test
  @TestMetadata("insert.kt")
  public void testInsert() {
    runTest("testData/box/insert.kt");
  }

  @Test
  @TestMetadata("join.kt")
  public void testJoin() {
    runTest("testData/box/join.kt");
  }

  @Test
  @TestMetadata("join_1.kt")
  public void testJoin_1() {
    runTest("testData/box/join_1.kt");
  }

  @Test
  @TestMetadata("localTypeExposure.kt")
  public void testLocalTypeExposure() {
    runTest("testData/box/localTypeExposure.kt");
  }

  @Test
  @TestMetadata("lowerGeneratedImplicitReceiver.kt")
  public void testLowerGeneratedImplicitReceiver() {
    runTest("testData/box/lowerGeneratedImplicitReceiver.kt");
  }

  @Test
  @TestMetadata("main.kt")
  public void testMain() {
    runTest("testData/box/main.kt");
  }

  @Test
  @TestMetadata("nestedDataSchemaCodegen.kt")
  public void testNestedDataSchemaCodegen() {
    runTest("testData/box/nestedDataSchemaCodegen.kt");
  }

  @Test
  @TestMetadata("OuterClass.kt")
  public void testOuterClass() {
    runTest("testData/box/OuterClass.kt");
  }

  @Test
  @TestMetadata("parametrizedDataFrame.kt")
  public void testParametrizedDataFrame() {
    runTest("testData/box/parametrizedDataFrame.kt");
  }

  @Test
  @TestMetadata("platformType.kt")
  public void testPlatformType() {
    runTest("testData/box/platformType.kt");
  }

  @Test
  @TestMetadata("propertiesOrder.kt")
  public void testPropertiesOrder() {
    runTest("testData/box/propertiesOrder.kt");
  }

  @Test
  @TestMetadata("read.kt")
  public void testRead() {
    runTest("testData/box/read.kt");
  }

  @Test
  @TestMetadata("readCSV.kt")
  public void testReadCSV() {
    runTest("testData/box/readCSV.kt");
  }

  @Test
  @TestMetadata("readDelimStr_delimiter.kt")
  public void testReadDelimStr_delimiter() {
    runTest("testData/box/readDelimStr_delimiter.kt");
  }

  @Test
  @TestMetadata("readJson.kt")
  public void testReadJson() {
    runTest("testData/box/readJson.kt");
  }

  @Test
  @TestMetadata("readJsonStr_const.kt")
  public void testReadJsonStr_const() {
    runTest("testData/box/readJsonStr_const.kt");
  }

  @Test
  @TestMetadata("readJsonStr_localProperty.kt")
  public void testReadJsonStr_localProperty() {
    runTest("testData/box/readJsonStr_localProperty.kt");
  }

  @Test
  @TestMetadata("readJsonStr_memberProperty.kt")
  public void testReadJsonStr_memberProperty() {
    runTest("testData/box/readJsonStr_memberProperty.kt");
  }

  @Test
  @TestMetadata("remove.kt")
  public void testRemove() {
    runTest("testData/box/remove.kt");
  }

  @Test
  @TestMetadata("rename.kt")
  public void testRename() {
    runTest("testData/box/rename.kt");
  }

  @Test
  @TestMetadata("Schema.kt")
  public void testSchema() {
    runTest("testData/box/Schema.kt");
  }

  @Test
  @TestMetadata("select.kt")
  public void testSelect() {
    runTest("testData/box/select.kt");
  }

  @Test
  @TestMetadata("selectIt.kt")
  public void testSelectIt() {
    runTest("testData/box/selectIt.kt");
  }

  @Test
  @TestMetadata("selectThis.kt")
  public void testSelectThis() {
    runTest("testData/box/selectThis.kt");
  }

  @Test
  @TestMetadata("selectionDsl.kt")
  public void testSelectionDsl() {
    runTest("testData/box/selectionDsl.kt");
  }

  @Test
  @TestMetadata("toDataFrame.kt")
  public void testToDataFrame() {
    runTest("testData/box/toDataFrame.kt");
  }

  @Test
  @TestMetadata("toDataFrame_dsl.kt")
  public void testToDataFrame_dsl() {
    runTest("testData/box/toDataFrame_dsl.kt");
  }

  @Test
  @TestMetadata("toDataFrame_from.kt")
  public void testToDataFrame_from() {
    runTest("testData/box/toDataFrame_from.kt");
  }

  @Test
  @TestMetadata("toDataFrame_superType.kt")
  public void testToDataFrame_superType() {
    runTest("testData/box/toDataFrame_superType.kt");
  }

  @Test
  @TestMetadata("toDataFrame_typeParameters.kt")
  public void testToDataFrame_typeParameters() {
    runTest("testData/box/toDataFrame_typeParameters.kt");
  }

  @Test
  @TestMetadata("transformReplaceFunctionCall.kt")
  public void testTransformReplaceFunctionCall() {
    runTest("testData/box/transformReplaceFunctionCall.kt");
  }

  @Test
  @TestMetadata("ungroup.kt")
  public void testUngroup() {
    runTest("testData/box/ungroup.kt");
  }

  @Nested
  @TestMetadata("testData/box/colKinds")
  @TestDataPath("$PROJECT_ROOT")
  public class ColKinds {
    @Test
    @TestMetadata("add.kt")
    public void testAdd() {
      runTest("testData/box/colKinds/add.kt");
    }

    @Test
    public void testAllFilesPresentInColKinds() {
      KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("testData/box/colKinds"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @Test
    @TestMetadata("toDataFrame.kt")
    public void testToDataFrame() {
      runTest("testData/box/colKinds/toDataFrame.kt");
    }
  }
}
