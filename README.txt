WATER REFILLING STATION DELIVERY & ORDER REGISTRY SYSTEM
Java + Maven + SQLite (SQLiteStudio compatible)

PACKAGE
com.yourdomain

REQUIREMENTS
- JDK 17 or later
- IntelliJ IDEA
- Maven (IntelliJ can import the included pom.xml)
- SQLiteStudio (optional, for inspecting the database)

PROJECT STRUCTURE
SECTION_LASTNAME_MIDTERM/
|-- src/main/java/com/yourdomain/
|   |-- Main.java
|   |-- dao/
|   |   |-- DatabaseConnection.java
|   |   `-- ScenarioDao.java
|   |-- model/
|   |   `-- ScenarioEntity.java
|   `-- ui/
|       `-- ScenarioMenu.java
|-- resources/
|-- pom.xml
|-- scenario.db
`-- README.txt

FEATURES
[1] Add Delivery Order
[2] View Active Orders (all saved orders)
[3] Exit System

Each record has five fields: order ID, customer name, quantity of 5-gallon containers,
quantity of 1-gallon containers, and order status. Status must be PENDING, DELIVERING,
or DELIVERED. Quantities must be whole numbers >= 0.

DAO SEPARATION
- DatabaseConnection.java: opens SQLite JDBC connections and enables PRAGMA foreign_keys.
- ScenarioDao.java: contains SQL statements and all database operations.
- ScenarioMenu.java: console prompts and aligned output only; no SQL or JDBC.
- Main.java: application startup only; no SQL or JDBC.

RUN IN INTELLIJ
1. Extract the ZIP.
2. Rename SECTION_LASTNAME_MIDTERM to your actual section and surname, if required.
3. Open the extracted folder in IntelliJ IDEA.
4. If prompted, choose "Load Maven Project" / "Trust Project".
5. Set Project SDK to JDK 17 or newer.
6. Ensure the working directory in Run Configuration is the project root (the folder containing pom.xml and scenario.db).
7. Run src/main/java/com/yourdomain/Main.java.
8. On the first run, the app creates the table if it does not exist.

RUN WITH MAVEN
From the project root, run:
mvn clean compile exec:java

SQLITESTUDIO
1. Open SQLiteStudio.
2. Choose Database > Add a database.
3. Browse to the extracted project's scenario.db file and add it.
4. Expand Tables and open water_orders.
5. After adding records in the Java app, refresh/reopen the table in SQLiteStudio to see them.

IMPORTANT DATABASE PATH NOTE
The application uses ./scenario.db relative to the project's working directory. Keep the Run
Configuration working directory at the project root. This makes the app and SQLiteStudio use
the same database file. Do not open a different scenario.db elsewhere.

DATABASE TABLE
water_orders:
- order_id INTEGER PRIMARY KEY AUTOINCREMENT
- customer_name TEXT NOT NULL
- qty_5_gallon INTEGER NOT NULL
- qty_1_gallon INTEGER NOT NULL
- order_status TEXT NOT NULL

All SQL and JDBC database operations are confined to the dao package.
