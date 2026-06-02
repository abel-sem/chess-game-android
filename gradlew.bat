@echo off
REM Gradle wrapper batch file (simplified)
SET DIRNAME=%~dp0
SET CLASSPATH=%DIRNAME%gradle\wrapper\gradle-wrapper.jar
IF NOT EXIST "%CLASSPATH%" (
  echo Warning: gradle-wrapper.jar not found. The Gradle wrapper will not run until the jar is added or the wrapper is generated.
  echo You can still build using the system Gradle (if installed): gradle assembleDebug
)
"%JAVA_HOME%\bin\java" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
