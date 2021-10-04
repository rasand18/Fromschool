/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// scalastyle:off println

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
// $example on$
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.util.MLUtils
// $example off$

object DecisionTreeClassificationExample {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val conf = new SparkConf().setAppName("DecisionTreeClassificationExample").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // $example on$
    // Load and parse the data file.
    val data = MLUtils.loadLibSVMFile(sc, "data/ml-TEST.txt")

    // Split the data into training and test sets (30% held out for testing)
    val splits = data.randomSplit(Array(0.7, 0.3))
    val (trainingData, testData) = (splits(0), splits(1))

    // Train a DecisionTree model.
    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    val numClasses = 4 // Number of classes
    val categoricalFeaturesInfo = Map[Int, Int]() //
    val impurity = "gini"
    val maxDepth = 11 // Maximum depth of a tree
    val maxBins = 32 // Number of bins used when discretizing continuous features

    val model = DecisionTree.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo,
      impurity, maxDepth, maxBins)

    // Evaluate model on test instances and compute test error
    val labelAndPreds = testData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    val testErr = labelAndPreds.filter(r => r._1 != r._2).count().toDouble / testData.count()
    println(s"Test Error = $testErr")
    println(s"Learned classification tree model:\n ${model.toDebugString}")

    sc.stop()
  }
}
// scalastyle:on println

//SVM - SVM is an image file format that can store vector and raster bitmaps. SVM files are associated with OpenOffice,
// a free office productivity suite. Files with SVM suffix are used by OpenOffice image processing module.
// Any image imported to Office document is converted to SVM file for easier image editing and processing.


//1) Alcohol
//2) Malic acid
//3) Ash
//4) Alcalinity of ash
//5) Magnesium
//6) Total phenols
//7) Flavanoids
//8) Nonflavanoid phenols
//9) Proanthocyanins
//10)Color intensity
//11)Hue
//12)OD280/OD315 of diluted wines
//13)Proline