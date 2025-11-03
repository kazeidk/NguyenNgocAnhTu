#!/bin/bash
# Script to compile and run Sports Booking System (JDK 1.8 compatible)

echo "=================================="
echo "Sports Booking System - Launcher"
echo "=================================="

# Create bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files with JDK 1.8 compatibility
echo "Compiling Java files (JDK 1.8)..."
javac -encoding UTF-8 -source 1.8 -target 1.8 -d bin src/*.java src/model/*.java src/manager/*.java src/util/*.java src/view/*.java 2>&1 | grep -v "bootstrap class path" | grep -v "obsolete" | grep -v "suppress warnings"

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
