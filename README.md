# data_science_scala

Simple implementation of various algorithms using Scala

## Dependencies

- <a href="https://github.com/scalanlp/breeze/tree/master/math/src/main/scala/breeze">Breeze</a>
- <a href="https://scalapy.dev/">ScalaPy</a>




## Issues

- ```java.lang.UnsatisfiedLinkError: Can't load library: /usr/lib/jvm/java-11-openjdk-amd64/lib/libawt_xawt.so``` 
On a Ubuntu machine try to install the Java 11 JDK:

```
sudo apt install openjdk-11-jdk
```


## Examples

### Reinforcement Learning

- <a href="src/main/scala/examples/rl/Example1_CreateGym_World.scala">Create an OpenAI Gym world with ScalaPy</a>

#### Dynamic Programming

- <a href="src/main/scala/examples/rl/Example3_IterativePoicyEvaluation.scala">Iterative policy evaluation on ```FrozenLake-v0```</a>
- <a href="src/main/scala/examples/rl/Example4_PolicyImprovement_FrozenLake.scala">Policy improvement on ```FrozenLake-v0```</a>
- <a href="src/main/scala/examples/rl/Example5_PolicyIteration_FrozenLake">Policy iteration on ```FrozenLake-v0```</a>
- <a href="src/main/scala/examples/rl/Example2_ValueIteration.scala">Value iteration on ```FrozenLake-v0```</a>

#### Monte Carlo

#### Temporal Differencing


### Machine Learning

#### Supervised Learning

- <a href="src/main/scala/examples/regression/LinearRegressionExe_1.scala">Linear regression</a>
- <a href="src/main/scala/examples/classification/LogisticRegression_Exe.scala">Logistic regression</a>


## Images

<img src="images/state_value_function.png"
     alt="Carrot Patth Following"
     style="float: left; margin-right: 10px; width: 500px;" />


