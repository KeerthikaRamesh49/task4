# NetBeans Setup Steps - Quick Reference

## Quick Start Checklist

- [ ] **Step 1**: Create a new Java Application project in NetBeans
- [ ] **Step 2**: Download MySQL Connector/J driver (.jar file)
- [ ] **Step 3**: Add MySQL driver to project Libraries
- [ ] **Step 4**: Create MySQL database using database_schema.sql
- [ ] **Step 5**: Copy DatabaseConnection.java to source folder
- [ ] **Step 6**: Update database credentials in DatabaseConnection.java
- [ ] **Step 7**: Test database connection (run DatabaseConnection class)
- [ ] **Step 8**: Copy LoginForm.java to source folder
- [ ] **Step 9**: Copy Homepage.java to source folder
- [ ] **Step 10**: Run LoginForm and test the application

---

## Creating a New NetBeans Project

### Option 1: GUI-Based Application Project
1. Open NetBeans
2. Click **File > New Project**
3. Select **Java** category
4. Choose **Java Application**
5. Click **Next**
6. Project Name: `MyAppProject`
7. Project Location: Choose your desired location
8. Click **Finish**

### Option 2: Desktop Application
1. Click **File > New Project**
2. Select **Java** category
3. Choose **Java Desktop Application**
4. Click **Next**
5. Fill in project details and click **Finish**
6. NetBeans will create a project with sample code

---

## Adding MySQL Driver to NetBeans

### Method 1: Using Project Properties
1. Right-click your project name in **Projects panel**
2. Select **Properties**
3. In the left panel, click **Libraries**
4. Under **Compile** tab, click **Add JAR/Folder**
5. Browse to mysql-connector-java-x.x.xx.jar
6. Click **Open**
7. Click **OK** to save

### Method 2: Using Libraries Folder
1. In **Projects** panel, expand your project
2. Right-click **Libraries** folder
3. Select **Add JAR/Folder**
4. Navigate to mysql-connector-java jar file
5. Click **Open**

### Verify Driver is Added
1. Expand **Libraries** in Projects panel
2. You should see **mysql-connector-java-x.x.xx.jar** listed
3. If not visible, the driver is not properly added

---

## Setting Up MySQL Database

### Using MySQL Workbench
1. Open MySQL Workbench
2. Click **File > Open SQL Script**
3. Select `database_schema.sql`
4. Review the SQL statements
5. Click **Execute** (lightning bolt icon) or press **Ctrl + Enter**
6. Check **Messages** tab for success message

### Using Command Line (Windows)
```bash
cd C:\Program Files\MySQL\MySQL Server 8.0\bin
mysql -u root -p < C:\path\to\database_schema.sql
```
When prompted, enter your MySQL password.

### Using phpMyAdmin (XAMPP)
1. Open phpMyAdmin: http://localhost/phpmyadmin
2. Click **Import** tab
3. Click **Choose File** and select `database_schema.sql`
4. Click **Import**

---

## Adding Java Source Files to NetBeans

### Method 1: Copy-Paste Method
1. In **Projects** panel, right-click **Source Packages**
2. Select the package (or create one by right-clicking > New > Package)
3. Right-click the package > **New > Java Class**
4. Name it `DatabaseConnection`
5. Copy the contents from `DatabaseConnection.java` file
6. Paste into the NetBeans editor
7. Repeat for `LoginForm.java` and `Homepage.java`

### Method 2: Import Existing Files
1. In **Projects** panel, right-click your project
2. Select **Properties > Sources**
3. Under **Source Package Folder**, add the folder containing your Java files
4. NetBeans will automatically include all .java files

---

## Running Your Application

### Test Database Connection First
1. In **Projects** panel, right-click `DatabaseConnection.java`
2. Select **Run File** (or press **Shift + F6**)
3. Check **Output** window:
   - Success: "Connected to MySQL database!"
   - Error: Review error message and troubleshoot

### Run LoginForm
1. After successful database connection test
2. Right-click `LoginForm.java`
3. Select **Run File** (or press **Shift + F6**)
4. Login window should open
5. Test with sample credentials:
   - Username: `john_doe`
   - Password: `password123`

### Run Entire Project
1. Click **Run > Run Project** (or press **F6**)
2. The startup class (LoginForm) should open automatically

---

## Debugging Tips

### Set Breakpoints
1. Click on line number in code editor (left margin)
2. A red dot appears indicating breakpoint
3. Run in Debug mode: **Debug > Debug Project** (**Ctrl + F5**)

### View Variable Values
1. When execution stops at breakpoint
2. Hover over variable to see its value
3. Or use **Debug > Variables** from the menu

### Step Through Code
1. Use **Debug > Step Over** (**F8**) to move to next line
2. Use **Debug > Step Into** (**F7**) to enter method calls
3. Use **Debug > Continue** (**F5**) to resume execution

---

## Common NetBeans Shortcuts

| Shortcut | Action |
|----------|--------|
| Ctrl + N | New file/class |
| Ctrl + S | Save file |
| Ctrl + Shift + S | Save all files |
| F6 | Run project |
| Shift + F6 | Run single file |
| Ctrl + F5 | Debug project |
| Ctrl + Shift + F | Format code |
| Ctrl + Space | Auto-complete |
| Ctrl + Alt + O | Organize imports |
| Ctrl + H | Replace in files |
| Ctrl + Shift + I | Fix imports |

---

## Project Structure After Setup

```
MyAppProject/
├── src/
│   ├── myappproject/
│   │   ├── DatabaseConnection.java
│   │   ├── LoginForm.java
│   │   ├── Homepage.java
│   │   └── Main.java (entry point)
│   └── other packages...
├── Libraries/
│   ├── mysql-connector-java-8.0.33.jar ← Added driver
│   └── JDK version
├── build/
├── dist/
└── nbproject/
```

---

## Next Steps

1. **Customize Homepage**: Add more features and buttons
2. **Create Profile Page**: Build ProfileForm.java
3. **Create Settings Page**: Build SettingsForm.java
4. **Add Database Operations**: Create queries for CRUD operations
5. **Implement Authentication**: Use password hashing (MD5, SHA-256)
6. **Deploy Application**: Build JAR file for distribution

---

## Troubleshooting

### Problem: "MySQL JDBC Driver not found"
**Solution**: 
- Verify mysql-connector-java jar is added to Libraries
- Clean project (right-click project > Clean)
- Rebuild project (right-click project > Build)

### Problem: "Cannot find symbol" on import statements
**Solution**:
- Right-click class > Fix Imports (Ctrl + Shift + I)
- If errors persist, add missing libraries

### Problem: "Connection refused" when connecting to database
**Solution**:
- Ensure MySQL server is running
- Verify hostname and port (default: localhost:3306)
- Check database name exists

### Problem: Form components not displayed properly
**Solution**:
- In Design View, select form background
- Use **Format > Auto Resize Form**
- Adjust component positions manually

---

## Resources

- **NetBeans Documentation**: https://netbeans.apache.org/tutorial/
- **MySQL Documentation**: https://dev.mysql.com/doc/
- **Java Swing Documentation**: https://docs.oracle.com/javase/tutorial/uiswing/
- **JDBC Tutorials**: https://docs.oracle.com/javase/tutorial/jdbc/

---

Need help? Check the TASK4_GUIDE.md file for detailed instructions!
