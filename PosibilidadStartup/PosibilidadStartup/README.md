# 🚀 PosibilidadStartup
### Evaluador de ideas para Ingeniería de Sistemas — en pesos colombianos (COP)

---

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
  ╔══════════════════════════════════════════════╗
  ║   🚀 TechEval — Evaluador de Ideas          ║
  ║      Para Ingeniería de Sistemas             ║
  ╚══════════════════════════════════════════════╝

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
