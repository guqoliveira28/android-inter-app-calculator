# Calculator Apps (Client & Server)

This repository contains two Android applications: a Calculator Server and a Calculator Client. The Server app performs calculations in the background, and the Client app provides a user interface to initiate calculations and view the history.

## Table of Contents

-   Setup and Installation
-   Calculator Server App
    -   Project Structure
    -   Key Components
-   Calculator Client App
    -   Project Structure
    -   Key Components
-   Unit Tests
-   License

## Setup and Installation

1.  **APK Installation:**
    
    -   Download the `CalculatorServer.apk` and `CalculatorClient.apk` files.
    -   Enable "Install from Unknown Sources" on your Android device or emulator.
    -   Install both APKs.

2.  **Running the Apps:**
    
    -    Open the Calculator Server app first.
    -   Open the Calculator Client app.
    -   Enter two numbers and select an operation.
    -   Click "Calculate" to send the calculation request to the Server app.
    -   The Server app will perform the calculation in the background and send the result back to the Client app.
    -   The Client app will display the result and add the calculation to the history.

## Calculator Server App

The Server app runs in the background and performs the actual calculations. It remains on background as a foreground service to ensure the Android OS won’t shut down the app.

### Project Structure

```
CalculatorServer/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/calculatorserver/
│   │       │       ├── MainActivity.java
│   │       │       ├── receiver/
│   │       │       │   ├── CalculationReceiver.java
│   │       │       ├── service/
│   │       │       │   ├── CalculationService.java
│   │       │       ├── operations/
│   │       │       │   ├── OperationInterface.java
│   │       │       │   ├── BaseOperation.java
│   │       │       │   ├── AddOperation.java
│   │       │       │   ├── SubtractOperation.java
│   │       │       │   ├── MultiplyOperation.java
│   │       │       │   ├── DivideOperation.java
│   │       │       ├── notification/
│   │       │       │   └── NotificationsHelper.java
│   │       ├── res/
│   │       │   └── ... (Resources)
│   │       └── AndroidManifest.xml
│   └── ... (Other project files)
├── ... (Other project files)

```

### Key Components

-   **`MainActivity.java`:**
    -   Starts the background service.
-   **`CalculationReceiver.java`:**
    -   Handles the broadcast receiver to process the calculations.
-   **`operations/` Package:**
    -   **`OperationInterface.java`:** Defines the `Operation` interface.
    -   **`BaseOperation.java`:** Abstract class extended by each operation, defining result formatting.
    -   **`AddOperation.java`, `SubtractOperation.java`, `MultiplyOperation.java`, `DivideOperation.java`:** Concrete operation implementations.
-   **`NotificationsHelper.java`:**
    -   Creates the foreground notification to keep the app running.
-   **`CalculationService.java`:**
    -   Creates the foreground service to keep the app running and registers the broadcast receiver.

## Calculator Client App

The Client app provides a user interface for users to input calculations and view their history.

### Project Structure

```
CalculatorClient/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/calculatorclient/
│   │       │       ├── ui/
│   │       │       │   ├── MainActivity.java
│   │       │       │   ├── SimpleAlertDialog.java
│   │       │       ├── adapters/
│   │       │       │   ├── HistoryViewAdapter.java
│   │       │       ├── database/
│   │       │       │   ├── DatabaseMigrationV1toV2.java
│   │       │       │   ├── OperationDao.java
│   │       │       │   ├── OperationDatabase.java
│   │       │       │   ├── OperationEntity.java
│   │       │       │   ├── OperationRepository.java
│   │       │       ├── listeners/
│   │       │       │   ├── RecyclerItemClickListener.java
│   │       │       ├── receiver/
│   │       │       │   ├── CalculationResultReceiver.java
│   │       │       ├── utils/
│   │       │       │   ├── CalculationUtils.java
│   │       │       │   ├── Constants.java
│   │       │       │   └── StringArrayUtils.java
│   │       ├── res/
│   │       │   └── ... (Resources)
│   │       └── AndroidManifest.xml
│   └── ... (Other project files)
├── ... (Other project files)

```

### Key Components

-   **`ui/` Package:**
    -   **`MainActivity.java`:** Handles views, listeners, result broadcast receiver, and startup.
    -   **`SimpleAlertDialog.java`:** Custom alert dialog.
-   **`adapters/` Package:**
    -   **`HistoryViewAdapter.java`:** Binds views to data.
-   **`database/` Package:**
    -   **`DatabaseMigrationV1toV2.java`:** Handles database migration.
    -   **`OperationDao.java`:** Interacts with stored data.
    -   **`OperationDatabase.java`:** Defines the database class.
    -   **`OperationEntity.java`:** Defines the operation entity.
    -   **`OperationRepository.java`:** Communicates with the DAO.
-   **`listeners/` Package:**
    -   **`RecyclerItemClickListener.java`:** Defines history RecyclerView click listeners.
-   **`receiver/` Package:**
    -   **`CalculationResultReceiver.java`:** Handles the result broadcast receiver.
-   **`utils/` Package:**
    -   **`CalculationUtils.java`:** Sends calculation data to the Server app.
    -   **`Constants.java`:** Contains constants.
    -   **`StringArrayUtils.java`:** Optimized string array index search.

## Unit Tests

Unit tests are included to ensure the reliability of core components. To run the unit tests:

1.  Open the project in Android Studio.
2.  Navigate to the test folder for each app.
3.  Right-click on the test class or package and select "Run."

## License

