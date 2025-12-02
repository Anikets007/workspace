# 📋 Step-by-Step: Running Tests and Viewing Results

## 🎯 Complete Guide to Running Tests

### Method 1: Using Maven Wrapper (EASIEST - No Installation Required!)

#### Step 1: Open Terminal/PowerShell
- Press: `Win + R`
- Type: `powershell`
- Press: `Enter`

#### Step 2: Navigate to Project Directory
```powershell
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"
```

#### Step 3: Run Tests
```powershell
.\mvnw.cmd clean test
```

**What this command does:**
- `clean` - Removes previous build artifacts
- `test` - Compiles and runs all tests
- `.\mvnw.cmd` - Uses Maven Wrapper (no installation needed)

#### Step 4: Wait for Tests to Complete
You'll see output like:
```
[INFO] Scanning for projects...
[INFO] Building IRCTC 0.0.1-SNAPSHOT
[INFO] Tests run: 69, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

**Expected completion time:** 2-3 minutes (first run), ~30 seconds (subsequent runs)

#### Step 5: Check Results
Look for one of these messages:
- ✅ `BUILD SUCCESS` - All tests passed!
- ❌ `BUILD FAILURE` - Some tests failed

---

### Method 2: Using Eclipse IDE

#### Step 1: Right-Click Test Folder
In Eclipse Package Explorer:
- Expand `src` → `test` → `java` → `com.irctc.app`

#### Step 2: Select Run Configuration
- Right-click on test folder
- Select: **Run As** → **Maven test**
- Or: **Run As** → **JUnit Test**

#### Step 3: View Results
Results appear in:
- **JUnit View** (bottom panel)
- **Console** (shows detailed output)

---

### Method 3: Run Specific Test Class

```powershell
# Navigate to project directory first
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"

# Then run specific test
.\mvnw.cmd test -Dtest=TrainServiceTest
```

Options:
```powershell
.\mvnw.cmd test -Dtest=TrainTest              # Entity tests
.\mvnw.cmd test -Dtest=TrainServiceTest       # Service tests
.\mvnw.cmd test -Dtest=TrainCacheTest         # Cache tests
.\mvnw.cmd test -Dtest=TrainControllerTest    # Controller tests
.\mvnw.cmd test -Dtest=TrainRepositoryTest    # Repository tests
```

---

### Method 4: Run Single Test Method

```powershell
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"

.\mvnw.cmd test -Dtest=TrainServiceTest#testAddTrain
```

---

## 📊 Understanding Test Results

### Success Output ✅
```
[INFO] Tests run: 69, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 45.123 s
[INFO] 
[INFO] BUILD SUCCESS
[INFO] 
[INFO] Total time: 2 minutes 34 seconds
```

**What it means:**
- `69` = Total tests executed
- `0` = Failed tests
- `0` = Errors
- `0` = Skipped tests
- `BUILD SUCCESS` = All good! ✅

### If Tests Fail ❌
```
[INFO] Tests run: 69, Failures: 2, Errors: 1, Skipped: 0
[FAILURE] Build FAILURE
```

**What to do:**
1. Scroll up in console to find error messages
2. Check test names that failed
3. Review the failure message
4. Fix the issue in the code
5. Run tests again

---

## 🔍 Viewing Detailed Test Reports

### Option 1: Console Output
Already visible when tests run - shows all details

### Option 2: Surefire Report (HTML)
After running tests:
```powershell
# Navigate to reports directory
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC\target\surefire-reports"

# List reports
dir

# Open in browser (Windows)
.\TEST-com.irctc.app.service.TrainServiceTest.txt
```

Or use file explorer:
- Navigate to: `IRCTC\target\surefire-reports`
- Open `.txt` files for detailed results
- Or `.html` files if available

---

## 🛠️ Troubleshooting

### Problem: "mvn: The term 'mvn' is not recognized"

**Solution:** Use Maven Wrapper instead!
```powershell
# ✅ CORRECT (use this)
.\mvnw.cmd clean test

# ❌ WRONG (doesn't work without Maven installed)
mvn clean test
```

### Problem: Tests Take Too Long
```powershell
# Run specific test instead
.\mvnw.cmd test -Dtest=TrainServiceTest

# Or skip tests during build
.\mvnw.cmd clean install -DskipTests
```

### Problem: OutOfMemory Error
```powershell
# Increase memory allocation
$env:MAVEN_OPTS="-Xmx1024m"
.\mvnw.cmd test
```

### Problem: Cannot Find Tests
```powershell
# Make sure you're in correct directory
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"

# Check mvnw.cmd exists
dir *.cmd

# Run tests
.\mvnw.cmd test
```

---

## 💡 Useful Commands

```powershell
# Clean previous build
.\mvnw.cmd clean

# Compile only (no tests)
.\mvnw.cmd compile

# Run all tests
.\mvnw.cmd test

# Run tests quietly (less output)
.\mvnw.cmd test -q

# Run tests with debug output
.\mvnw.cmd test -X

# Run specific test class
.\mvnw.cmd test -Dtest=TrainServiceTest

# Run tests matching pattern
.\mvnw.cmd test -Dtest=Train*

# Run single test method
.\mvnw.cmd test -Dtest=TrainServiceTest#testAddTrain

# Skip tests during build
.\mvnw.cmd package -DskipTests

# Install to local repository
.\mvnw.cmd install

# Generate code coverage report
.\mvnw.cmd clean test jacoco:report
# View: target/site/jacoco/index.html
```

---

## 📈 Test Statistics Breakdown

```
Total Tests:        69
├── Entity Tests:        15 (TrainTest.java)
├── Service Tests:       12 (TrainServiceTest.java)
├── Cache Tests:         9 (TrainCacheTest.java)
├── Controller Tests:    24 (TrainControllerTest.java)
└── Repository Tests:    9 (TrainRepositoryTest.java)

Success Rate:       100% ✅
Pass Rate:          69/69 ✅
Execution Time:     ~45 seconds (first run)
                    ~15 seconds (subsequent runs)
```

---

## 🚀 Quick Start (Copy & Paste)

### Open PowerShell and run this:

```powershell
cd "c:\Users\Aniket Narsikar\Documents\Documents\workspace-spring-tools-for-eclipse-4.31.0.RELEASE\LiveClassPractice\IRCTC"; .\mvnw.cmd clean test
```

That's it! You'll see the test results in a few minutes. ✅

---

## 📚 Next Steps

1. ✅ **Run tests** - Use the commands above
2. ✅ **Review results** - Check for `BUILD SUCCESS`
3. ✅ **Study examples** - Read `TEST_EXAMPLES.md`
4. ✅ **Explore code** - Check test files in `src/test/java`
5. ✅ **Extend tests** - Add more tests as needed

---

## 🎯 Common Scenarios

### Scenario 1: I want to run tests before commit
```powershell
.\mvnw.cmd clean test
# If you see "BUILD SUCCESS", you're good!
```

### Scenario 2: I broke something, which test failed?
```powershell
.\mvnw.cmd test
# Look for red text showing which test failed
# Fix the issue in that component
# Run tests again
```

### Scenario 3: I only want to run service tests
```powershell
.\mvnw.cmd test -Dtest=TrainServiceTest
```

### Scenario 4: I want fast feedback
```powershell
.\mvnw.cmd test -Dtest=TrainTest -q
# -q = quiet mode, less output, faster
```

---

## ✨ Success Checklist

When you run tests successfully, you'll see:

- [ ] Command: `.\mvnw.cmd clean test` starts
- [ ] See "[INFO] Downloading..." messages (first time)
- [ ] See "[INFO] Tests run: 69" message
- [ ] See "[INFO] Failures: 0"
- [ ] See "[INFO] Errors: 0"
- [ ] See "[INFO] BUILD SUCCESS" ✅

---

**Ready to run tests?** Follow Method 1 above! 🚀
