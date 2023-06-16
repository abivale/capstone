<h1> Machine Learning </h1>

<h2> Code Summary </h2>
<p1> First, enter data including its class with the for function and to read the path where the data is stored using the glob library. After that use cv2 to read the entered image and normalize it. Then all the images that have been entered and grouped by class are randomized and made into an array. After that, we  start building the model with tensorflow. Finally, using matplotlib.pyplot to draw graph accuracy and loss as evaluation material. For processing which data is used as a train and which data is used for validation. We use validation of 20% of the existing dataset. We also made the model in .JSON format and try it on local with prediction of the image that we input in the form console logs.</p1>

<h2>How we works?</h2>
<p1> We consist of two people and decided to make one model of each of us. Thus producing 2 models

<h2> Model Differences </h2>
<p1> One with dropout and one without dropout </p1>
  
<h2> Best model stats </h2>
  <p1>
    <b>The stats below at any time may differ from those in the notebook because the model still wants to be improved</b>
    <img src="https://github.com/abivale/capstone/blob/main/machine-learning/acc_vs_acc-val.png?raw=true">
    <img src="https://github.com/abivale/capstone/blob/main/machine-learning/loss_vs_val-loss.png?raw=true">
  </p1>
  
  <h2> Architecture </h2>
  <p1>
    <b>With dropout</b>
    <img src="https://github.com/abivale/capstone/blob/main/machine-learning/with-dropout-summary.png?raw=true" >
    <b>Without drop out</b>
    <img src="https://github.com/abivale/capstone/blob/main/machine-learning/without-dropout-summary.png?raw=true">     
  </p1>

  <h2> Dataset </h2>
  <p1> Link : https://www.kaggle.com/datasets/shashwatwork/fruitnet-indian-fruits-dataset-with-quality </p1> <br> 
  <p1> Provenance : https://data.mendeley.com/datasets/b6fftwbr2v/1 </p1> <br>
  <p1> License : https://creativecommons.org/licenses/by-sa/4.0/ </p1>
