@echo off
title BigarrenAukera.Launcher
cls

javac Erronka\Aplikazioa.java

if %errorLevel% neq 0 (
    echo.
    echo [ERROR] Bigarren Aukera.exe ez da ondo exekutatu.
    goto FIN
)

java -Xmx128m Erronka/Aplikazioa

pause
