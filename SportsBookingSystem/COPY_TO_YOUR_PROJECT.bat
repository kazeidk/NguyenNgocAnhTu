@echo off
chcp 65001 >nul
echo ╔══════════════════════════════════════════════════════════════╗
echo ║           SCRIPT COPY FILES TO YOUR PROJECT                  ║
echo ╚══════════════════════════════════════════════════════════════╝
echo.

set "TARGET=C:\Users\nguye\OneDrive\Tài liệu\IA1902\Lab211\SportsBookingSystem"

echo Checking if target exists...
if not exist "%TARGET%" (
    echo ERROR: Target folder not found!
    echo %TARGET%
    pause
    exit /b 1
)

echo ✓ Target folder found
echo.
echo Copying files...
echo.

REM Copy source files
echo [1/8] Copying Main.java...
copy /Y "src\Main.java" "%TARGET%\src\Main.java"

echo [2/8] Copying Validator.java...
copy /Y "src\util\Validator.java" "%TARGET%\src\util\Validator.java"

echo [3/8] Copying Menu.java...
copy /Y "src\view\Menu.java" "%TARGET%\src\view\Menu.java"

echo [4/8] Copying BookingManager.java...
copy /Y "src\manager\BookingManager.java" "%TARGET%\src\manager\BookingManager.java"

echo [5/8] Copying FacilityManager.java...
copy /Y "src\manager\FacilityManager.java" "%TARGET%\src\manager\FacilityManager.java"

echo [6/8] Copying build.xml...
copy /Y "build.xml" "%TARGET%\build.xml"

echo [7/8] Copying build-impl.xml...
copy /Y "nbproject\build-impl.xml" "%TARGET%\nbproject\build-impl.xml"

echo [8/8] Copying project.properties...
copy /Y "nbproject\project.properties" "%TARGET%\nbproject\project.properties"

echo.
echo ════════════════════════════════════════════════════════════════
echo ✅ ALL FILES COPIED SUCCESSFULLY!
echo ════════════════════════════════════════════════════════════════
echo.
echo Next steps:
echo 1. Open NetBeans 13
echo 2. Open project: %TARGET%
echo 3. Right-click project ^> Clean
echo 4. Right-click project ^> Build
echo 5. Press F6 to Run
echo.
echo ════════════════════════════════════════════════════════════════
pause
