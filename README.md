# Bank USSD App
## This app was developed using JAVA 11
## This app runns on console

### 1. The aim of this app is to implement the OPP principles
        - Encapsulation
        - Inheritence
        - Abstraction 
        - Polymophisim 
        - Interfaces 
### 2. On app startup, the user is asked to create or login into an account.
        - Please not that the user verification is not implemented.
### 3. The created account will be saved on the text file (useraccounts.txt) on database package.
### 4. The user is automaticaly loggedin after creating an account or choose option 2 to login using phone number and password.
### 5. After the access is granted, the user will be asked to choose to the menu on what transaction they need to do.
### 6. For each successful transaction, the transaction details will be saved in transaction history text fine on database package.

### 7. OOP
        - The Main class is used to start and run the application.
        - The Account class inherit from the AccountUser class.
        - The ITransactions is an interface that implements the methods from Transactions Class.
        - USSD class inherits from TransactionHistory class will it implements IUSSD interface methods.
        - Transactions class inherits TransactionHistory class.
        - Encapsulation is implemented by using access specifiers.
        - Polymophisim is implemented by overriding different methods.
