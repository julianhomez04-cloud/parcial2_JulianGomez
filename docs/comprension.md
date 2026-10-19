# Comprensión del diseño — Enunciado C
**Nombre:** Julian Gomez Homez
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Curso` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> Tu respuesta:Curso es abstracta porque no tiene sentido crear un curso “genérico”: en el sistema solo existen cursos obligatorios, electivos y nivelatorios. La clase obliga a cada subclase a implementar dificultadEsperada(), y cada una la calcula distinto. Lo que gana el sistema es polimorfismo: PlanEstudios puede recorrer un ArrayList<Curso> y llamar dificultadEsperada() sin saber de qué tipo es cada curso. Si mañana aparece un cuarto tipo de curso, ese código no cambia.

---

### 2. Composición vs. agregación
Explica la diferencia entre `PlanEstudios ◆— Curso` (composición) y
`Facultad ◇— PlanEstudios` (agregación). ¿Qué pasaría con los cursos si se
elimina el plan? ¿Y con los planes si se elimina la facultad?

> Tu respuesta:En la composición, los cursos se crean dentro del constructor de PlanEstudios y no tienen vida propia, así que si el plan se elimina, sus cursos desaparecen con él. En la agregación, los planes se crean por fuera y se registran con agregarPlan(). La facultad solo guarda referencias, así que si se elimina la facultad, los planes siguen existiendo.

---

### 3. Asociación
En `Estudiante — Curso`, ¿quién es dueño de quién? ¿Por qué se modela como
N:M y no como composición?

> Tu respuesta:Ninguno es dueño del otro: Estudiante solo guarda referencias a los cursos en inscritos, y un curso existe aunque el estudiante desaparezca. Es N:M porque un estudiante cursa varios cursos y un mismo curso lo cursan varios estudiantes. No puede ser composición porque entonces el curso pertenecería a un solo estudiante y moriría con él.

---

### 4. Dependencia
¿Por qué `Recomendador` **depende** de `HistorialAcademico` en lugar de
**tenerlo** como atributo? ¿Qué ventaja tiene pasar el servicio como
parámetro?

> Tu respuesta:Recomendador solo necesita el historial durante recomendar(), no tiene por qué recordarlo después. Al pasarlo como parámetro, el mismo Recomendador sirve para cualquier estudiante, no guarda estado y queda menos acoplado. Además es más fácil de probar, porque cada prueba le pasa el historial que quiera.

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] notas` en `Estudiante`
- `ArrayList<Curso>` en `PlanEstudios` y `Estudiante`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
pasa si el estudiante intenta registrar más notas que la capacidad del
arreglo?

> Tu respuesta:int[] notas se usa porque el enunciado define una capacidad fija conocida desde el constructor, y guarda valores primitivos. ArrayList<Curso> se usa porque no se sabe cuántos cursos habrá y la lista puede crecer sola. Si el estudiante intenta registrar más notas que la capacidad, registrarNota revisa contadorNotas >= notas.length y no guarda la nota, el contador no aumenta y se evita un ArrayIndexOutOfBoundsException.