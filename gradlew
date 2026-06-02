#!/usr/bin/env bash
# Gradle wrapper (simplified)
# Note: gradle-wrapper.jar is not included. You can generate it by running 'gradle wrapper' in Codespaces or on a machine with Gradle installed.

DIRNAME="$(cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 && pwd)"
APPNAME="$0"

if [ -z "$JAVA_HOME" ]; then
  JAVA="java"
else
  JAVA="$JAVA_HOME/bin/java"
fi

CLASSPATH="$DIRNAME/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$CLASSPATH" ]; then
  echo "Warning: gradle-wrapper.jar not found. The Gradle wrapper will not run until the jar is added or the wrapper is generated."
  echo "You can still build using the system Gradle (if installed): gradle assembleDebug"
fi

exec "$JAVA" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
