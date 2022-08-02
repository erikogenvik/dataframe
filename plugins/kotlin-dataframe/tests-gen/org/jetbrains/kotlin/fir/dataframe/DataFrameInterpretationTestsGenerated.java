/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.dataframe;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link GenerateNewCompilerTests.kt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("plugins/kotlin-dataframe/testData/interpretation")
@TestDataPath("$PROJECT_ROOT")
public class DataFrameInterpretationTestsGenerated extends AbstractDataFrameInterpretationTests {
    @Test
    @TestMetadata("add.kt")
    public void testAdd() throws Exception {
        runTest("plugins/kotlin-dataframe/testData/interpretation/add.kt");
    }

    @Test
    public void testAllFilesPresentInInterpretation() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlin-dataframe/testData/interpretation"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @Test
    @TestMetadata("convert.kt")
    public void testConvert() throws Exception {
        runTest("plugins/kotlin-dataframe/testData/interpretation/convert.kt");
    }

    @Nested
    @TestMetadata("plugins/kotlin-dataframe/testData/interpretation/atoms")
    @TestDataPath("$PROJECT_ROOT")
    public class Atoms {
        @Test
        @TestMetadata("addExpression.kt")
        public void testAddExpression() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/addExpression.kt");
        }

        @Test
        public void testAllFilesPresentInAtoms() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("plugins/kotlin-dataframe/testData/interpretation/atoms"), Pattern.compile("^(.+)\\.kt$"), null, true);
        }

        @Test
        @TestMetadata("dataFrame.kt")
        public void testDataFrame() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/dataFrame.kt");
        }

        @Test
        @TestMetadata("enum.kt")
        public void testEnum() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/enum.kt");
        }

        @Test
        @TestMetadata("insertClause.kt")
        public void testInsertClause() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/insertClause.kt");
        }

        @Test
        @TestMetadata("KProperties.kt")
        public void testKProperties() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/KProperties.kt");
        }

        @Test
        @TestMetadata("kproperty.kt")
        public void testKproperty() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/kproperty.kt");
        }

        @Test
        @TestMetadata("string.kt")
        public void testString() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/string.kt");
        }

        @Test
        @TestMetadata("type.kt")
        public void testType() throws Exception {
            runTest("plugins/kotlin-dataframe/testData/interpretation/atoms/type.kt");
        }
    }
}
