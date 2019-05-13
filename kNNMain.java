import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
    
    String PATH_TO_DATA = args[0];
    
//    List<DataPoint> myList = DataSet.readDataSet(PATH_TO_DATA);
//    
//    DataPoint dp1 = myList.get(0);
//    DataPoint dp2 = myList.get(1);
//    
//    double[] dpx = dp1.getX();
//    
//    String printableX = Arrays.toString(dpx);
    
//    System.out.println(printableX);
//    System.out.println(dp1.getLabel());
//    System.out.println(dp1.getLabelAsDouble());

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
    
//    List<DataPoint> test = DataSet.getTestSet(myList, 0.2);
//    List<DataPoint> train = DataSet.getTrainingSet(myList, 0.8);
    
//    DataSet.printDataSet(test);
//    System.out.println();
//    DataSet.printDataSet(train);
//    System.out.println();
//    System.out.println("myList: " + DataSet.getLabels(myList));
//    DataSet.printLabelFrequencies(myList);
//    System.out.println("test:");
//    DataSet.printLabelFrequencies(test);
//    System.out.println("train:");
//    DataSet.printLabelFrequencies(train);

    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
    
//    double dist = DataSet.distanceEuclid(dp1, dp2);
//    System.out.println(dist);


    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label
    
//    KNNClassifier object = new KNNClassifier(5);
//    DataPoint[] kNearest = object.getNearestNeighbors(myList, dp1);
//    String myLabel = object.predict(myList, kNearest[0]);
//    System.out.println(myLabel);

    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.
    //System.out.println(kNearest.length);
//    int count = 0;
//    for(int i = 0; i < test.size(); i++){
//      DataPoint wht = test.get(i);
//      String predicted = object.predict(train, wht);
//      if (predicted.equals(wht.getLabel())){
//        count ++; 
//      }
//    }
    //System.out.println(count); 
    //System.out.println((double) count/test.size()*100);
    
    /////////////////
    //1000 times/////
    /////////////////
    KNNClassifier object = new KNNClassifier(5);
//    String predicted;
    int counter = 0;
    double[] sum = new double[1000];
    double[] precision = new double[1000];
    double[] recall = new double[1000];
    int truePos = 0;
    int falsePos = 0;
    int falseNeg = 0;
    
    for (int i = 0; i < 1000; i++)
    {
    List<DataPoint> myList = DataSet.readDataSet(PATH_TO_DATA);
    List<DataPoint> test = DataSet.getTestSet(myList, 0.3);
    List<DataPoint> train = DataSet.getTrainingSet(myList, 0.7);

//      test = DataSet.getTestSet(myList, 0.3);
//      train = DataSet.getTrainingSet(myList, 0.7);
      
      for(int e = 0; e < test.size(); e++)
      {
        DataPoint myDP = test.get(e);
        String predicted = object.predict(train, myDP);
        if (predicted.equals(myDP.getLabel())) //predicted right
        {
          counter ++; 
          if (predicted.equals("malignant"))
          {
            truePos ++;
          }
        } //big if
        else //predicted wrong
        {
         if (predicted.equals("malignant"))
         {
           falseNeg ++;
         }
         else //if (predicted.equals("benign"))
         {
           falsePos ++;
         }  
        }//big else
      }// forloop
      precision[i] = ((double) (truePos))/(truePos+falsePos);
      recall[i] = ((double) (truePos))/(truePos+falseNeg);
      
      double dCounter = (double) (counter);
      double dSize = (double) (test.size());
      double accuracy = (dCounter/dSize) *100;
      sum[i] = accuracy;
      //System.out.println(sum[i]);
      counter = 0;
      truePos = 0;
      falsePos = 0;
      falseNeg = 0;
    }//big forloop
    double myMean = mean(sum);
    double mySD = standardDeviation(sum);
    System.out.println("Mean: " + myMean + "\tSD " + mySD);
    System.out.println("Mean precision: " + mean(precision) + "\tSD precision " + standardDeviation(precision));
    System.out.println("Mean recall: " + mean(recall) + "\tSD recall " + standardDeviation(recall));
    
    List<DataPoint> tList = DataSet.readDataSet(PATH_TO_DATA);
    DataSet.printLabelFrequencies(tList);
  }//main

  public static double mean(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: average of the elements of array, as a double
    */
    double sum = 0.0;

    for (double a : arr){
      sum += a;
    }
    return (double)sum/arr.length;
  }

  public static double standardDeviation(double[] arr){
    /*
    Method that takes as an argument an array of doubles
    Returns: standard deviation of the elements of array, as a double
    Dependencies: requires the *mean* method written above
    */
    double avg = mean(arr);
    double sum = 0.0;
    for (double a : arr){
      sum += Math.pow(a-avg,2);
    }
    return (double)sum/arr.length;
  }

}
