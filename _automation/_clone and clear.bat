@Echo off
cd ..
::robocopy of jar
echo Copied jar outside dev-environment
robocopy build\libs\ _automation > nul
TIMEOUT /NOBREAK /T 1 > nul
::del of all generated files
echo Removing of garbage files
rd /s /q .gradle
rd /s /q build
TIMEOUT /NOBREAK /T 1 > nul
echo ##Execution completed##