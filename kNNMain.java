import java.util.List;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class kNNMain{

  public static void main(String... args) throws FileNotFoundException{

    // TASK 1: Use command line arguments to point DataSet.readDataSet method to
    // the desired file. Choose a given DataPoint, and print its features and label
    
    String PATH_TO_DATA = args[0];
    
    List<DataPoint> myList = DataSet.readDataSet(PATH_TO_DATA);
    
    DataPoint dp1 = myList.get(0);
    DataPoint dp2 = myList.get(1);
    
    double[] dpx = dp1.getX();
    
    String printableX = Arrays.toString(dpx);
    
    System.out.println(printableX);
    System.out.println(dp1.getLabel());
    System.out.println(dp1.getLabelAsDouble());

    //TASK 2:Use the DataSet class to split the fullDataSet into Training and Held Out Test Dataset
    
    List<DataPoint> test = DataSet.getTestSet(myList, 0.2);
    List<DataPoint> train = DataSet.getTrainingSet(myList, 0.8);
    
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

    // TASK 3: Use the DataSet class methods to plot the 2D data (binary and multi-class)



    // TASK 4: write a new method in DataSet.java which takes as arguments to DataPoint objects,
    // and returns the Euclidean distance between those two points (as a double)
    
    double dist = DataSet.distanceEuclid(dp1, dp2);
    System.out.println(dist);


    // TASK 5: Use the KNNClassifier class to determine the k nearest neighbors to a given DataPoint,
    // and make a print a predicted target label



    // TASK 6: loop over the datapoints in the held out test set, and make predictions for Each
    // point based on nearest neighbors in training set. Calculate accuracy of model.


  }

}
