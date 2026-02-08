# Task 4: Connect to MySQL Database and Design the Homepage - Complete Guide

## Part 1: Setting Up MySQL JDBC Driver

### Step 1.1: Download MySQL Connector/J
1. Visit: https://dev.mysql.com/downloads/connector/j/
2. Download the **Platform Independent** .zip file (e.g., mysql-connector-java-8.0.33.jar)
3. Extract the .jar file

### Step 1.2: Add Driver to NetBeans Project
1. Open your NetBeans project
2. In **Project Explorer** on the left:
   - Right-click **Libraries** (under your project)
   - Select **Add JAR/Folder**
   - Navigate to the downloaded mysql-connector-java-8.0.33.jar file
   - Click **Open** to add it

#### Alternative Method (If Libraries folder doesn't exist):
1. Right-click your project > **Properties**
2. Go to **Libraries** tab
3. Click **Add JAR/Folder**
4. Select the MySQL Connector/J .jar file

---

## Part 2: Create DatabaseConnection Class

### Step 2.1: Create the Class in NetBeans
1. In Project Explorer, right-click your **Source Packages** folder
2. Select **New > Java Class**
3. Name it: `DatabaseConnection`
4. Click **Finish**

### Step 2.2: Configure Database Credentials
1. Open `DatabaseConnection.java`
2. Update the following variables with your MySQL credentials:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
   private static final String USER = "your_mysql_username";  // default: "root"
   private static final String PASSWORD = "your_mysql_password";
   ```

### Step 2.3: Example Configuration (for XAMPP users):
```java
private static final String URL = "jdbc:mysql://localhost:3306/myapp_db";
private static final String USER = "root";
private static final String PASSWORD = "";  // XAMPP usually has empty password
```

### Step 2.4: Test the Connection
1. Run the `DatabaseConnection` class: **Right-click > Run File** or press **Shift + F6**
2. Check the Output window:
   - **Success**: "Connected to MySQL database!"
   - **Error**: Check error message and verify:
     - MySQL server is running (e.g., via XAMPP)
     - Database name exists
     - Username and password are correct

#### Troubleshooting:
- **"Connected refused"**: Ensure MySQL is running
- **"Unknown database"**: Create the database first with MySQL Workbench or phpMyAdmin
- **"Access denied"**: Check username and password

---

## Part 3: Create Homepage JFrame Form

### Step 3.1: Create the JFrame Form in NetBeans
1. In Project Explorer, right-click **Source Packages**
2. Select **New > JFrame Form**
3. Name it: `Homepage`
4. Click **Finish**
5. NetBeans will open the **Design View**

### Step 3.2: Design the Interface (Using GUI Builder)

#### Option A: Using the GUI Builder (Drag & Drop)
1. **Add Title Label**:
   - From the Palette (right panel), drag **Label** to the form
   - In Properties, set:
     - **text**: "Welcome to the Homepage"
     - **font**: Arial, Bold, size 20
     - **horizontalAlignment**: Center

2. **Add Greeting Label**:
   - Drag another Label below the title
   - In Properties, set:
     - **text**: "Hello, User!"
     - **font**: Arial, Plain, size 14
     - **horizontalAlignment**: Center

3. **Add Buttons**:
   - Drag three **Button** components
   - Configure each:
     - **Button 1**: text = "View Profile", name = "viewProfileButton"
     - **Button 2**: text = "Settings", name = "settingsButton"
     - **Button 3**: text = "Logout", name = "logoutButton"
   - Set preferred size for each button: **150 x 40 pixels**

4. **Arrange Layout**:
   - Select all components
   - Use **Format > Align > Center** from the menu
   - Adjust spacing using **Format > Spacing > Increase/Decrease**
   - Or use GroupLayout for precise positioning

#### Option B: Use Provided Code
If you prefer, use the `Homepage.java` file provided, which has all layout configured in code.

### Step 3.3: Add Action Listeners

#### For View Profile Button:
1. Switch to **Source** view
2. Find `viewProfileButtonActionPerformed()` method
3. Replace the TODO section with:
   ```java
   JOptionPane.showMessageDialog(this, "Profile feature coming soon!");
   // TODO: Navigate to ProfileFrame
   ```

#### For Settings Button:
1. Find `settingsButtonActionPerformed()` method
2. Add:
   ```java
   JOptionPane.showMessageDialog(this, "Settings feature coming soon!");
   // TODO: Navigate to SettingsFrame
   ```

#### For Logout Button:
1. Find `logoutButtonActionPerformed()` method
2. Add:
   ```java
   int response = JOptionPane.showConfirmDialog(this, 
       "Are you sure you want to logout?", 
       "Confirm Logout", 
       JOptionPane.YES_NO_OPTION);
   if (response == JOptionPane.YES_OPTION) {
       this.dispose(); // Close homepage
       new LoginForm().setVisible(true); // Open login form
   }
   ```

---

## Part 4: Test the Homepage

### Step 4.1: Run the Homepage
1. Right-click the `Homepage` class
2. Select **Run File** or press **Shift + F6**

### Step 4.2: Verify Components
Check that:
- [ ] Title label displays "Welcome to the Homepage"
- [ ] Greeting label shows "Hello, User!"
- [ ] All three buttons (View Profile, Settings, Logout) are visible
- [ ] Buttons are horizontally centered
- [ ] Buttons respond to clicks

### Step 4.3: Test Logout
- Click **Logout** button
- Confirm the dialog
- Homepage should close

---

## Part 5: Connect Homepage to LoginForm (Optional)

If you have a `LoginForm` class:

1. Update `Homepage.java` Logout method:
```java
private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
    this.dispose(); // Close homepage
    new LoginForm().setVisible(true); // Open login form
}
```

2. Update `LoginForm.java` to open Homepage on successful login:
```java
new Homepage().setVisible(true);
this.dispose();
```

---

## Part 6: Next Steps - Database Operations

### Add Database Query Methods to DatabaseConnection:

```java
// Example: Validate login credentials
public static User validateLogin(String username, String password) {
    Connection conn = getConnection();
    // Execute SQL query to validate user
    // Return User object if found
    return null; // Placeholder
}

// Example: Get user profile
public static UserProfile getUserProfile(int userId) {
    // Execute SQL query to fetch profile
    return null; // Placeholder
}
```

### Create Supporting Classes:
1. `User.java` - User model class
2. `UserProfile.java` - Profile model class
3. `LoginForm.java` - Login interface (if not yet created)
4. `ProfileForm.java` - User profile page
5. `SettingsForm.java` - Settings page

---

## Troubleshooting Checklist

| Issue | Solution |
|-------|----------|
| MySQL Connection Fails | Verify MySQL is running via XAMPP/Command line |
| "Driver not found" | Re-add mysql-connector-java.jar to Libraries |
| Database doesn't exist | Create database using MySQL Workbench or phpMyAdmin |
| Wrong credentials | Update DatabaseConnection.java with correct username/password |
| Homepage won't run | Ensure Java SDK is properly configured in NetBeans |
| Components overlap in Design View | Use Format menu to auto-arrange or apply GroupLayout |

---

## File Checklist

You should have these files in your NetBeans project:

```
src/
├── DatabaseConnection.java      (Database connection class)
├── Homepage.java                (Homepage JFrame form)
├── LoginForm.java               (Login page - if created)
└── [Other form classes]
```

---

## File Documentation

### DatabaseConnection.java
- **Purpose**: Manages MySQL database connections
- **Key Method**: `getConnection()` - Returns a Connection object
- **Must Update**: URL, USER, PASSWORD variables with your MySQL credentials

### Homepage.java
- **Purpose**: Main homepage displayed after login
- **Components**: Title, Greeting, and three navigation buttons
- **Button Actions**: View Profile, Settings, Logout
- **Layout**: GroupLayout for proper alignment

---

## Running the Application

1. **Test Database Connection**:
   ```
   Right-click DatabaseConnection.java > Run File
   ```

2. **Test Homepage Interface**:
   ```
   Right-click Homepage.java > Run File
   ```

3. **Run Full Project**:
   ```
   Right-click Project > Run (or press Shift + F6)
   ```

---

## Save Your Work

After each change:
- Press **Ctrl + S** to save files
- Commit to version control if using Git
- Keep backups of working versions

---

Good luck with your Task 4! Contact me if you encounter any issues.
