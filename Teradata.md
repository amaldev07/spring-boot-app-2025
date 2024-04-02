1. Create hosted instance of Vantage for testing and development purposes at 
https://clearscape.teradata.com/

Create an acc there
To create DB and Table
    1. Access the SQL Interface:

        Navigate to the ClearScape Analytics Experience dashboard.​
        teradata.com 
        Click on the Run Demos button to launch JupyterLab, which provides an SQL interface.​
         
        Open a Teradata SQL Notebook:

        In JupyterLab, click the blue + icon in the top-left corner to open the Launcher.​
        Under the Notebooks section, select Teradata SQL to open a new SQL notebook.​

        Connect to the Teradata Database:

        In the first cell of the notebook, establish a connection to the database by executing:​
         
        %connect local
        You will be prompted to enter your database password.​
        Create a New Database:

        Decide on the name and space allocation for your new database. For example, to create a database named my_database with 100 MB of permanent space, execute:​
        
        CREATE DATABASE my_database AS PERM = 100e6;
        Ensure that the user account you are using has the necessary privileges to create a database.​
        Create a Table within the New Database:

        Switch to the newly created database:​
         
        DATABASE my_database;
        Define and create your table. For instance, to create a table named employees, execute:​
         
        CREATE TABLE employees (
            employee_id INTEGER,
            first_name VARCHAR(50),
            last_name VARCHAR(50),
            hire_date DATE
        )
        PRIMARY INDEX (employee_id);
        This command sets employee_id as the primary index, which helps distribute data evenly across processing units.​
        communities.sas.com
        Verify the Table Creation:

        To confirm that the table has been created successfully, you can run:​
       
        HELP TABLE employees;
        This command will display the table's structure and attributes.

--------------------------------
To see this db and tables in teradata express studio i installed in my local

Step 1: Obtain Connection Details from ClearScape
    Log into your ClearScape account.
    From the ClearScape Analytics workspace, note:
    Host name (Teradata server address)
    Database username
    Password for your ClearScape instance.
    Port number (usually 1025 or provided explicitly).

Step 2: Configure Teradata Studio
    Open Teradata Studio locally.

    Go to File → New → Other → Connection Profile → Teradata.

    Fill in these details:

    Name: ClearScape Cloud
    Host: (ClearScape hostname from above)
    User name: (ClearScape username)
    Password: (ClearScape password)
    Database: (Optional—default is your user's default database)
    Authentication mechanism: TD2 (default)
    Port: (usually 1025 or as specified)
    Click Test Connection:

    Verify successful connection.
    Click Finish.

Step 3: Browse your ClearScape Database from Teradata Studio
    On the left pane in Teradata Studio:
    Expand the new connection (ClearScape Cloud).
    Expand Databases → Select your newly created database (e.g., my_database).
    Expand Tables to view your created tables (e.g., employees).