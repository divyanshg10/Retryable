# Retry Mechanism Example (Java)

A simple Java project demonstrating a retry mechanism with configurable retry count and interval. The `Retryable` class allows executing tasks with automatic retries on failure. The `Main` class provides an example usage.

## Contents

1. [Project Overview](#1-project-overview)
2. [Features](#2-features)
3. [Getting Started](#3-getting-started)
4. [Usage Example](#4-usage-example)
5. [Project Structure](#5-project-structure)
6. [License](#6-license)

---

## 1. Project Overview

This project implements a generic retry mechanism in Java. It is useful for operations that may fail intermittently and need to be retried automatically.

## 2. Features

- Configurable retry count and interval
- Simple API using Java's `Runnable`
- Example usage in the `Main` class

## 3. Getting Started

**Requirements:**
- Java 8 or higher
- Gradle

**Build and Run:**
```sh
./gradlew build
./gradlew run
```

## 4. Usage Example

The `Main` class demonstrates how to use the `Retryable` class:

```java
Retryable retryable = new Retryable(3, 1000);

retryable.execute(() -> {
    // Simulate a task that may fail
    if (Math.random() < 0.7) {
        throw new RuntimeException("Simulated failure");
    }
    System.out.println("Task succeeded");
});
```

## 5. Project Structure

- `src/main/java/io/divyanshg10/Retryable.java` - Retry mechanism implementation
- `src/main/java/io/divyanshg10/Main.java` - Example usage

## 6. License

This project is licensed under the MIT License.

