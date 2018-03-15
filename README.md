# Pact-JVM-Implementation

Example projects for https://github.com/DiUS/pact-jvm built in spring boot framework.
--------
#Installations 
- Install Java-7 or higher version
- Install IntelliJ IDEA for your operating system. (https://www.jetbrains.com/idea/download/)
- Clone the repository `git clone https://github.com/gopinath-langote/Pact-JVM-Implementation.git`
- Open the project(root directory `Pact-JVM-Implementation`) in `IntelliJ IDEA`. This will take a while to download dependencies.
- Go to the project directory `cd Pact-JVM-Implementation` 


##### Run following commands on the terminal or command prompt.

# Build the application
For Linux/Mac : `./gradlew clean build --no-daemon`

For Windows : `gradlew.bat clean build --no-daemon`

`This can take some time to download dependencies`

# Run the Customer Service (Producer service)
For Linux/Mac : `./gradlew :customer-service:bootRun --no-daemon` 

For Windows : `gradlew.bat :customer-service:bootRun --no-daemon` 

- Check service is running or not at [http://localhost:8052/customer](http://localhost:8052/customer)

# Run the Payment Service (Consumer service)
For Linux/Mac : `./gradlew :payment-service:bootRun --no-daemon` 

For Windows : `gradlew.bat :payment-service:bootRun --no-daemon` 

- Check service is running or not at [http://localhost:8051/payment](http://localhost:8051/payment)
