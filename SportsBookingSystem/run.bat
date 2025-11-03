@echo off
REM Script to compile and run Sports Booking System on Windows

echo ==================================
echo Sports Booking System - Launcher
echo ==================================

REM Create bin directory if it doesn't exist
if not exist bin mkdir bin

REM Compile all Java files
echo Compiling Java files...
javac -d bin src\*.java src\model\*.java src\manager\*.java src\util\*.java src\view\*.java

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
