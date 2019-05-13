# Report: Error Analysis
## 360-420-w2019 - Section 
## Jeremy Lackmann-Mincoff and Lyon Belyansky

## Distributions of Model Accuracy
Each time we run the model, we are getting a different accuracy because the model is being trained on a randomly shuffled training dataset. 

Running our model 1000 times, we get a mean accuracy of 96.9% and a standard deviation of 1.28. This shows that our model is getting a relatively good accuracy when tested on unseen data.

A sensible baseline could be to predict that all patients have a malignant tumor. In such a case, we would get an accuracy of 34.8%. On the other hand, if we predict all benign tumors, we would get an accuracy of 65.2%. 

## Analysis of different error types
A False Positive is a prediction of a malignant tumor whereas it is actually benign.
A False Negative is a prediction of a bening tumor whereas it is acutally malignant. 
It is clear that to make a False Negative is a much worse mistake in a medical context than to make a False Positive.
