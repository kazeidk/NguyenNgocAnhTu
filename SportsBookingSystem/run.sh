#!/bin/bash
# Script to compile and run Sports Booking System

echo "=================================="
echo "Sports Booking System - Launcher"
echo "=================================="

# Create bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files
echo "Compiling Java files..."
javac -d bin src/*.java src/model/*.java src/manager/*.java src/util/*.java src/view/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    
    # Run the application
    cd bin
    java Main
else
    echo "Compilation failed! Please check the errors above."
    exit 1
fi
