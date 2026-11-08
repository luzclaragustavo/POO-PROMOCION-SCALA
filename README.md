# POO en Scala – Trabajo de promoción

Ejemplos de los conceptos de Programación Orientada a Objetos en **Scala 3**, sobre el dominio de un cine.
Trabajo de promoción de Programación Orientada a Objetos (UNPSJB, 2026).

## Requisitos

- Scala 3 instalado con [Coursier](https://www.scala-lang.org/download/) (incluye Java si hace falta).

## Cómo ejecutar

En la carpeta del proyecto:

    scala run .

Se ejecutan los 7 ejemplos en orden y cada uno imprime su resultado.

## Ejemplos

| Archivo | Concepto |
|---|---|
| `Sala.scala` | Encapsulamiento: butacas privadas, `require` en el constructor, reserva validada |
| `Entrada.scala` | Clase abstracta, herencia, `super`, `override`, constructores y Factory (companion object) |
| `Reembolsable.scala` | Traits con estado y métodos concretos; los cumplen clases sin parentesco |
| `Funcion.scala` | Herencia múltiple con traits y linealización (el problema del diamante) |
| `Boleteria.scala` | Polimorfismo, patrón Strategy, Singleton (`object`) y principios SOLID (O y D) |
| `Concurrencia.scala` | Hilos, condición de carrera, `synchronized` y `Future` |
| `main.scala` | Punto de entrada: ejecuta todos los ejemplos |
