
# Report: Error Analysis
## 360-420-DW - Section 2
## Jeremy Lackmann-Mincoff and Lyon Belyansky

## Distributions of Model Accuracy
Each time we run the model, we are getting a different accuracy because the model is being trained on a different randomly shuffled training data-set. 

Running our model 1000 times, with k = 5, we get a mean accuracy of 96.9% and a standard deviation of 1.28. The training set includes 70% of the available data and the model is tested against the remaining 30% of data. This shows that our model is getting a relatively good accuracy when tested on unseen data.

This data-set has 444 benign data-points and 237 malignant data-points. A sensible baseline could be to predict that all patients have a malignant tumor. In such a case, we would get an accuracy of 34.8%. On the other hand, if we predict all benign tumors, we would get an accuracy of 65.2%. However, from a medical perspective, it is probably better to have a lower accuracy but making sure that all malignant tumors are correctly identified.

## Analysis of different error types

 - A False Positive is a prediction of a malignant tumor whereas it is actually benign. 
 - A False Negative is a prediction of a benign tumor whereas it is actually malignant.

It is clear that to make a False Negative is a much worse mistake in a medical context than to make a False Positive. The most relevant elements are the false negatives and the true positives predicted by our model.

Extending the analysis to keep track of Recall and Precision, we get a mean Precision of 95.3% with an SD of 7.21x10^-4 and a mean Recall of 95.6% with an SD of 4.65x10^-4.

 - The precision is a ratio of how many positive diagnostics does our
   model get right out of the total amount of positive diagnostics.  
 - The recall is a measure of how many positive cases our model identifies
   correctly out of the total number of malignant tumors.
   
By diagnosing every patient with a malignant tumor, we would get 100% recall, but a very low precision. In contrast, to get 100% precision, the model needs to make 0 false positives. This suggests that it is much harder to attain a perfect precision than a perfect recall. However, the best model will probably have high ratios in both classification types.

In general, increasing the value of the hyperparameter k seems to increase the mean recall, while decreasing both the overall accuracy and the precision. 