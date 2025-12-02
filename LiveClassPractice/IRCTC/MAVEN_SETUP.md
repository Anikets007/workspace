# Running Tests - Maven Setup Guide

## ✅ Maven Wrapper Setup (Recommended)

Your project includes **Maven Wrapper** (`mvnw.cmd`), which doesn't require Maven installation!

### Running Tests from Command Line

```powershell
# Navigate to project directory
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"

# Run all tests
.\mvnw.cmd clean test

# Run specific test class
.\mvnw.cmd test -Dtest=TrainServiceTest

# Run specific test method
.\mvnw.cmd test -Dtest=TrainServiceTest#testAddTrain

# Run tests quietly (less output)
.\mvnw.cmd test -q

# Skip tests (just build)
.\mvnw.cmd clean install -DskipTests
```

## Alternative: Using Eclipse IDE

### Method 1: Run from Package Explorer
1. Right-click on test file → **Run As** → **JUnit Test**
2. Or right-click on project folder → **Run As** → **Maven test**

### Method 2: Run All Tests
1. Right-click on `src/test/java` folder
2. Select **Run As** → **Maven test**

### Method 3: Run via Test View
1. Open **Window** → **Show View** → **JUnit**
2. Navigate to test class and click **Run** button

## Installation: Maven from Maven.Apache.Org

If you want to install Maven separately:

### Option 1: Using Chocolatey (if installed)
```powershell
choco install maven
```

### Option 2: Manual Installation
1. Download from: https://maven.apache.org/download.cgi
2. Extract to: `C:\Program Files\Apache\maven\`
3. Add to PATH environment variable:
   - Right-click This PC → Properties
   - Advanced system settings → Environment Variables
   - New user variable: `MAVEN_HOME` = `C:\Program Files\Apache\maven\`
   - Edit PATH: append `%MAVEN_HOME%\bin`
4. Verify:
   ```powershell
   mvn --version
   ```

## Test Results Location

After running tests, check:
- **Test Report**: `target/surefire-reports/`
- **Console Output**: Shows in terminal

## Maven Command Cheatsheet

```powershell
# Clean
.\mvnw.cmd clean

# Compile
.\mvnw.cmd compile

# Run tests
.\mvnw.cmd test

# Build jar
.\mvnw.cmd package

# Install to local repository
.\mvnw.cmd install

# Run specific tests
.\mvnw.cmd test -Dtest=TrainTest

# Run tests with pattern
.\mvnw.cmd test -Dtest=Train*

# Run with debug logging
.\mvnw.cmd test -X

# Generate coverage report
.\mvnw.cmd clean test jacoco:report

# Skip tests in build
.\mvnw.cmd clean install -DskipTests
```

## Expected Test Output

When tests run successfully, you should see:
```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.irctc.app.entity.TrainTest
...
[INFO] Tests run: 15, Failures: 0, Errors: 0, Skipped: 0
...
[INFO] Tests run: 69, Failures: 0, Errors: 0, Skipped: 0
[INFO] -------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] -------------------------------------------------------
```

## Troubleshooting

### Maven not found
- Use Maven Wrapper: `.\mvnw.cmd` instead of `mvn`
- Or install Maven properly (see above)

### Tests take too long
- Run single test: `.\mvnw.cmd test -Dtest=TrainServiceTest`
- Or use IDE's faster test runner

### Import errors in tests
- Run: `.\mvnw.cmd clean install -DskipTests`
- Then: `.\mvnw.cmd test`

### OutOfMemory errors
```powershell
$env:MAVEN_OPTS="-Xmx1024m"
.\mvnw.cmd test
```

## 🎯 Quick Start

```powershell
# 1. Navigate to project
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"

# 2. Run tests (using Maven Wrapper - no installation needed!)
.\mvnw.cmd clean test

# 3. Wait for results showing:
# Tests run: 69, Failures: 0, Errors: 0 ✅
```

---

**Pro Tip**: Use the Maven Wrapper (`mvnw.cmd`) - it's already configured and doesn't require system-wide Maven installation!
