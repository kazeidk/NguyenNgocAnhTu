@echo off
REM Script to compile and run Sports Booking System on Windows (JDK 1.8 compatible)

echo ==================================
echo Sports Booking System - Launcher
echo ==================================

REM Create bin directory if it doesn't exist
if not exist bin mkdir bin

REM Compile all Java files with JDK 1.8 compatibility
echo Compiling Java files (JDK 1.8)...
javac -encoding UTF-8 -source 1.8 -target 1.8 -d bin src\*.java src\model\*.java src\manager\*.java src\util\*.java src\view\*.java

if %errorlevel% equ 0 (
    echo Compilation successful!
    echo.
    
    REM Run the application
    cd bin
    java Main
) else (
    echo Compilation failed! Please check the errors above.
    exit /b 1
)
