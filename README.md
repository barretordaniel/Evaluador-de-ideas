# Evaluador de Ideas de Software

## 📌 Descripción

Es una aplicación desarrollada en Java que permite evaluar técnica y financieramente una idea de software antes de iniciar su desarrollo.  

El sistema analiza cuatro dimensiones clave: mercado, viabilidad técnica, costos y crecimiento proyectado, generando una evaluación estructurada que ayuda a reducir el riesgo de fracaso.

La herramienta transforma un proceso normalmente intuitivo en un análisis cuantificable y automatizado.

---

## ❓ Problema que Resuelve

Muchos proyectos de software fracasan por iniciar sin una validación previa adecuada.  

Los emprendedores suelen comenzar el desarrollo sin analizar:

- Si realmente existe mercado.
- Si el proyecto es técnicamente viable.
- Si los costos son sostenibles.
- Si el crecimiento proyectado permitirá alcanzar el punto de equilibrio.

TechEval aborda esta problemática proporcionando una evaluación integral antes de invertir tiempo y dinero.

---

## ⚙️ Funcionalidades

El sistema se compone de cuatro módulos principales:

### 1️⃣ Módulo de Mercado (30%)
Evalúa tamaño del mercado, claridad del problema, competencia, validación con usuarios y tiempo de salida al mercado.

### 2️⃣ Módulo Técnico (25%)
Analiza la complejidad del sistema, número de módulos, dependencias externas y capacidad del equipo de desarrollo.

### 3️⃣ Módulo de Costos (20%)
Calcula infraestructura mensual, costo de desarrollo, costo del MVP y costo proyectado del primer año.

### 4️⃣ Módulo de Crecimiento (25%)
Simula 12 meses de operación, proyecta crecimiento de usuarios, incorpora churn, calcula utilidad mensual y determina el punto de equilibrio.

---

## 💡 Hack Creativo

El componente innovador del proyecto consiste en convertir la validación de una idea en un sistema estructurado con puntaje ponderado.

La aplicación no solo realiza cálculos financieros, sino que interpreta los resultados y genera una clasificación automática del proyecto como:

- ✅ Viable  
- ⚠️ Riesgoso  
- ❌ No rentable  

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java  
- **IDE:** IntelliJ IDEA  
- **Paradigma:** Programación Orientada a Objetos  
- **Arquitectura:** Modular (estructura similar a MVC simplificado)  
- **Tipo de aplicación:** Consola  

---

## ▶️ Cómo Ejecutar el Proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Ejecutar la clase principal.
4. Ingresar los datos solicitados en consola.
5. Revisar los resultados generados automáticamente.

---

## 📊 Resultados del Sistema

Al finalizar la ejecución, el sistema muestra:

- Puntaje por módulo.
- Puntaje total ponderado.
- Clasificación del proyecto.
- Proyección financiera mensual.
- Punto de equilibrio estimado.

---

## 🚀 Posibles Mejoras Futuras

- Interfaz gráfica.
- Integración con APIs externas.
- Implementación de modelos predictivos con IA.
- Exportación automática de reportes en PDF.
- Simulación de múltiples escenarios comparativos.


## ¿Qué hace?

Aplicación de consola en Java que evalúa tu idea de software en **4 módulos sencillos**:

| # | Módulo | Pregunta clave |
|---|--------|----------------|
| 1 | 📊 Mercado | ¿Hay quién pague por esto? |
| 2 | ⚙️ Técnico | ¿Puedes construirlo? |
| 3 | 💰 Costos (COP) | ¿Cuánto necesitas invertir? |
| 4 | 📈 Crecimiento | ¿Cuándo recuperas la inversión? |

Al final genera un **Reporte con puntaje global** y veredicto de viabilidad.

---

## ▶️ Cómo ejecutar

### Opción 1 — Un solo archivo (más fácil)
```bash
# 1. Compilar
javac -d out src/com/techeval/Main.java

# 2. Ejecutar
java -cp out com.techeval.Main
```

### Opción 2 — Desde IntelliJ IDEA o Eclipse
1. Crea un nuevo proyecto Java
2. Copia `Main.java` en el paquete `com.techeval`
3. Ejecuta `Main.java`

---

## 📱 Cómo se ve

```

  Evaluador de Ideas         
  Para Ingeniería de Sistemas           
 

  Nombre de tu idea de proyecto: AppMercado

  ═══ MENÚ ══════════════════════════════════════
  Proyecto: AppMercado
  
  ✅ 1 → Validación de Mercado
  ✅ 2 → Planeación Técnica
  ⚠️  3 → Estimación de Costos
  ⬜ 4 → Simulación de Crecimiento
     5 → 📋 Ver Reporte Final
     0 → Salir
```

### Ejemplo de costos en COP:
```
  Infraestructura mensual:  $    82.000
  Costo estimado MVP:       $ 7.246.000
  Costo desarrollo total:   $21.000.000
  Costo total primer año:   $21.984.000
```

### Ejemplo de simulación:
```
  MES  │  USUARIOS  │    INGRESOS     │    COSTOS       │   UTILIDAD
  ─────┼────────────┼─────────────────┼─────────────────┼──────────────────
    1  │         50 │      $1.250.000 │      $3.025.000 │    -$1.775.000
    2  │         60 │      $1.500.000 │      $3.030.000 │    -$1.530.000
   ...
    8  │        145 │      $3.625.000 │      $3.072.500 │      $552.500  ◄ EQUILIBRIO
```

---

## 🛠 Requisitos

- Java 17 o superior (solo JDK, sin librerías externas)
- Terminal con soporte de colores (la mayoría los soporta)

---

*Un solo archivo `.java`, sin dependencias. ¡Listo para usar!*

