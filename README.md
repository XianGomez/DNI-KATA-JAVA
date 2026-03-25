# Refactorización de Validador de DNI: Python a Java

Este proyecto consiste en la migración y refactorización de un sistema de validación de DNI originalmente desarrollado en Python hacia Java. El proceso se ha realizado siguiendo la metodología **TDD (Test-Driven Development)**, asegurando que cada funcionalidad cumpla con los casos de prueba predefinidos.

## Objetivos del Proyecto

* **Migración de Lenguaje**: Traducir la lógica de tipado dinámico de Python a la estructura de tipado estático y fuerte de Java.
* **Diseño Orientado a Objetos**: Implementar patrones de diseño como la composición ("Has-a") para separar la lógica de la tabla de asignación de la entidad DNI.
* **Metodología TDD**: Superar de forma iterativa los casos de prueba unitarios, garantizando la robustez del código frente a entradas inválidas.

## Estructura de la Solución

El sistema se ha descompuesto en dos clases fundamentales para mejorar la mantenibilidad:

### 1. TablaAsignacion.java
Clase de soporte técnico que contiene la constante de caracteres permitidos.
* **Encapsulamiento**: El array de caracteres es privado y solo se accede mediante métodos de consulta.
* **Lógica Matemática**: Implementa el cálculo de la posición mediante la operación de módulo 23 sobre la parte numérica del documento.
* **Validación de Caracteres**: Provee métodos para verificar si un carácter específico pertenece al conjunto de letras legales.

### 2. Dni.java
Clase principal que representa el objeto de negocio.
* **Estado Interno**: Gestiona mediante banderas booleanas (`numeroSano`, `letraSana`) el ciclo de vida de la validación.
* **Composición**: Utiliza una instancia de `TablaAsignacion` para realizar los cálculos, desacoplando la estructura del documento de la regla de cálculo de la letra.
* **Validaciones**: Controla la longitud (9 caracteres), el formato (8 dígitos iniciales) y la integridad de la letra (mayúsculas y coincidencia matemática).

### Requisitos del Sistema
* Java JDK: Versión 17 o superior.
* Entorno de Testing: JUnit 5 para la ejecución de los casos de prueba.
