
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils


object Assessment2_ {

  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR)

    val conf = new SparkConf().setAppName("Assessment2_").setMaster("local[*]")
    val sc = new SparkContext(conf)

    // Load and parse the data file.
    val data = MLUtils.loadLibSVMFile(sc, "data/house-votes.svm")

    // Split the data into training and test sets (30% held out for testing)
    val splits = data.randomSplit(Array(0.7, 0.3))
    val (trainingData, testData) = (splits(0), splits(1))

    // Train a DecisionTree model.
    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    val numClasses = 3 // Number of classes
    val categoricalFeaturesInfo = Map[Int, Int]() //
    val impurity = "gini"
    val maxDepth = 3 // Maximum depth of a tree
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
    println(s"Learned classification tree model:\n ${model.toDebugString}"
      .replaceAll("feature 0 ","Republican or democrat")
      .replaceAll("feature 1 ","handicapped-infants")
      .replaceAll("feature 2 ","water-project-cost-sharing")
      .replaceAll("feature 3 ","adoption-of-the-budget-resolution")
      .replaceAll("feature 4 ","physician-fee-freeze")
      .replaceAll("feature 5 ","el-salvador-aid")
      .replaceAll("feature 6 ","religious-groups-in-schools")
      .replaceAll("feature 7 ","anti-satellite-test-ban")
      .replaceAll("feature 8 ","aid-to-nicaraguan-contras")
      .replaceAll("feature 9 ","mx-missile")
      .replaceAll("feature 10 ","immigration")
      .replaceAll("feature 11 ","synfuels-corporation-cutback")
      .replaceAll("feature 12 ","education-spending")
      .replaceAll("feature 13 ","superfund-right-to-sue")
      .replaceAll("feature 14 ","crime")
      .replaceAll("feature 15 ","duty-free-exports")
      .replaceAll("feature 16 ","export-administration-act-south-africa")
    )
    sc.stop()
  }
}