package com.techeval.posibilidadStartup;

import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);

    static String nombreProyecto = "";
    static double puntajeMercado   = 0;
    static double puntajeTecnico   = 0;
    static double puntajeCostos    = 0;
    static double puntajeCrecimiento = 0;

    static final String RESET   = "\u001B[0m";
    static final String VERDE   = "\u001B[32m";
    static final String ROJO    = "\u001B[31m";
    static final String AMARILLO= "\u001B[33m";
    static final String CYAN    = "\u001B[36m";
    static final String BOLD    = "\u001B[1m";
    static final String AZUL    = "\u001B[34m";

    public static void main(String[] args) {
        banner();
        System.out.print(AMARILLO + "  Nombre de tu idea de proyecto: " + RESET);
        nombreProyecto = sc.nextLine().trim();

        boolean salir = false;
        while (!salir) {
            menu();
            int op = leerInt("  Elige una opción: ", 0, 5);
            switch (op) {
                case 1 -> puntajeMercado = moduloMercado();
                case 2 -> puntajeTecnico = moduloTecnico();
                case 3 -> puntajeCostos = moduloCostos();
                case 4 -> puntajeCrecimiento = moduloCrecimiento();
                case 5 -> reporte();
                case 0 -> salir = true;
            }
        }
        System.out.println(CYAN + "\n  ¡Buena suerte con tu proyecto! 🚀" + RESET);
        sc.close();
    }


    //  MÓDULO 1 — MERCADO

    static double moduloMercado() {
        titulo("MÓDULO 1 — VALIDACIÓN DE MERCADO");
        System.out.println(CYAN + "  Responde del 1 (bajo) al 5 (alto)\n" + RESET);

        int tamano    = leerInt("  ¿Qué tan grande es el mercado? \n" +" (1 = Pocos usuarios potenciales, 5 = millones de usuarios potenciales): ", 1, 5);
        int problema  = leerInt("  ¿El problema que resuelves es claro y urgente?\n"+"(1 =vago, 5 = problema crítico y bien definido): ", 1, 5);
        int competencia = leerInt("  ¿Tienes ventaja sobre la competencia?\n" + " (1 = mercado saturado, 5 = sin competidores directos): ", 1, 5);
        int pago      = leerInt("  ¿Los usuarios pagarían por esto?\n" + " (1 = difícilmente, 5 = ya lo están buscando): ", 1, 5);
        int validacionUsuarios =leerInt("¿Has validado con usuarios reales (encuestas, entrevistas)?\n" + " (1 = no hice nada, 5 = tengo 20+ entrevistas): ", 1, 5);
        int tiempoAlMercado= leerInt("¿En cuántos meses estimas tener tu primer usuario real?",1,60 );

        double puntaje = (tamano + problema + competencia + pago + validacionUsuarios) / 25.0 * 100;
        if(tiempoAlMercado > 12 ) puntaje*=0.92;
        else if(tiempoAlMercado > 18 ) puntaje*=0.85;
        separador();
        System.out.printf("  Puntaje de mercado: %s%.0f / 100%s%n", colorPuntaje(puntaje), puntaje, RESET);
        System.out.println("  " + interpretarPuntaje(puntaje));
        pausa();
        return puntaje;
    }


    //  MÓDULO 2 — TÉCNICO

    static double moduloTecnico() {
        titulo("MÓDULO 2 — PLANEACIÓN TÉCNICA");

        System.out.print(AMARILLO + "  ¿Cuál es el lenguaje principal? (ej: Java): " + RESET);
        String lenguaje = sc.nextLine().trim();

        int modulos    = leerInt("  ¿Cuántas secciones/módulos tiene la app? (1-10): ", 1, 10);
        int apis       = leerInt("  ¿Cuántas APIs externas necesitas integrar? (0-5): ", 0, 5);
        int personas   = leerInt("  ¿Cuántas personas hay en el equipo? (1-10): ", 1, 10);
        int semanas    = leerInt("  ¿En cuántas semanas harías el primer prototipo? (1-24): ", 1, 24);

        // Calcular complejidad
        int score = modulos + apis * 2;
        String complejidad;
        double puntaje;
        if (score <= 5)       { complejidad = "BAJA";     puntaje = 90; }
        else if (score <= 9)  { complejidad = "MEDIA";    puntaje = 70; }
        else if (score <= 13) { complejidad = "ALTA";     puntaje = 50; }
        else                  { complejidad = "MUY ALTA"; puntaje = 30; }

        // Penalizar si el equipo es muy pequeño para la complejidad
        if (score > 9 && personas < 2) puntaje -= 15;
        // Premiar tiempo realista
        double semPorPersona = (double) semanas / personas;
        if (semPorPersona < 2) puntaje -= 10; // demasiado optimista

        puntaje = Math.max(0, Math.min(100, puntaje));

        separador();
        System.out.printf("  Lenguaje elegido:   %s%s%s%n", BOLD, lenguaje, RESET);
        System.out.printf("  Complejidad:        %s%s%s%n", colorPuntaje(100 - score * 5), complejidad, RESET);
        System.out.printf("  Puntaje técnico:    %s%.0f / 100%s%n", colorPuntaje(puntaje), puntaje, RESET);

        String recomArq = "Monolito con separación por capas (MVC/Clean Architecture)";
        System.out.println("  Arquitectura sugerida: " + recomArq);
        if (modulos <= 4 && personas <= 2) recomArq= "Monolito modular (ideal para MVP)";
        if (modulos > 8 && personas >= 4)  recomArq= "Microservicios con API Gateway";
                 pausa();
        return puntaje;
    }


    //  MÓDULO 3 — COSTOS 

    static double moduloCostos() {
        titulo("MÓDULO 3 — ESTIMACIÓN DE COSTOS");
        System.out.println(CYAN + "  Valores en pesos colombianos (COP)\n" + RESET);

        // Servidor en COP (aprox con tasa ~4.100 COP/USD)
        System.out.println("  Tamaño del servidor:");
        System.out.println("  1. Pequeño  —  $ 33.000/mes  (apps de prueba)");
        System.out.println("  2. Mediano  —  $  82.000/mes (hasta ~500 usuarios)");
        System.out.println("  3. Grande   —  $ 287.000/mes (hasta ~5.000 usuarios)");
        int srv = leerInt("  Elige (1-3): ", 1, 3);
        long[] costoServidor = {33_000L, 82_000L, 287_000L};
        long infra = costoServidor[srv - 1];

        boolean bd    = leerSN("  ¿Base de datos separada? (+$41.000/mes) (s/n): ");
        boolean email = leerSN("  ¿Servicio de correos? (+$20.000/mes) (s/n): ");
        boolean cdn   = leerSN("  ¿CDN / almacenamiento de archivos? (+$25.000/mes) (s/n): ");

        if (bd)    infra += 41_000;
        if (email) infra += 20_000;
        if (cdn)   infra += 25_000;

        int devs    = leerInt("  ¿Cuántos desarrolladores? (1-5): ", 1, 5);
        long salario = leerLong("  Salario mensual por desarrollador (COP, ej: 3500000): ");
        int meses   = leerInt("  ¿Cuántos meses de desarrollo? (1-12): ", 1, 12);

        long costoDesarrollo = devs * salario * meses;
        long costoMVP        = (long)(devs * salario * (meses / 3.0)) + (infra * 3);
        long costoAnio       = costoDesarrollo + (infra * 12);

        // Puntaje: qué tan asequible es
        double ratio = (double) infra / 200_000.0;
        double puntaje = Math.max(0, Math.min(100, 100 - ratio * 30));

        separador();
        System.out.printf("  Infraestructura mensual:  %s%s%s%n",   CYAN,  formatCOP(infra), RESET);
        System.out.printf("  Costo estimado MVP:       %s%s%s%n",   VERDE, formatCOP(costoMVP), RESET);
        System.out.printf("  Costo desarrollo total:   %s%s%s%n",   AMARILLO, formatCOP(costoDesarrollo), RESET);
        System.out.printf("  Costo total primer año:   %s%s%s%n",   ROJO,  formatCOP(costoAnio), RESET);
        System.out.printf("  Puntaje de costos:        %s%.0f / 100%s%n", colorPuntaje(puntaje), puntaje, RESET);
        pausa();
        return puntaje;
    }


    //  MÓDULO 4 — CRECIMIENTO

    static double moduloCrecimiento() {
        titulo("MÓDULO 4 — SIMULACIÓN DE CRECIMIENTO");
        System.out.println(CYAN + "  Precios en pesos colombianos (COP)\n" + RESET);

        System.out.println("  Modelo de cobro:");
        System.out.println("  1. Suscripción mensual");
        System.out.println("  2. Pago único");
        System.out.println("  3. Gratis (publicidad)");
        int modelo = leerInt("  Elige (1-3): ", 1, 3);

        long precioCOP = 0;
        if (modelo == 1) precioCOP = leerLong("  Precio mensual por usuario (COP, ej: 25000): ");
        else if (modelo == 2) precioCOP = leerLong("  Precio único por descarga/compra (COP, ej: 50000): ");
        else precioCOP = 1_500; // ARPU publicidad ~$1500 COP/usuario/mes

        int usuariosInicio = leerInt("  ¿Cuántos usuarios esperas el primer mes? (1-1000): ", 1, 1000);
        int crecimiento    = leerInt("  ¿% de crecimiento mensual esperado? (1-50): ", 1, 50);
        int churn          = leerInt("  ¿% de usuarios que se irán cada mes? (1-20): ", 1, 20);
        long costoFijo     = leerLong("  Costo fijo mensual total (COP, ej: 3000000): ");
        int mesesSim       = 12;

        // Simulación
        separador();
        System.out.println(BOLD + "  MES  │  USUARIOS  │    INGRESOS     │    COSTOS       │   UTILIDAD" + RESET);
        System.out.println("  ─────┼────────────┼─────────────────┼─────────────────┼──────────────────");

        double usuarios = usuariosInicio;
        int breakevenMes = -1;

        for (int mes = 1; mes <= mesesSim; mes++) {
            long ingresos;
            if (modelo == 1 || modelo == 3) {
                ingresos = (long)(usuarios * precioCOP);
            } else {
                // Venta única: solo nuevos usuarios compran
                ingresos = (long)(usuarios * (crecimiento / 100.0) * precioCOP);
            }

            long costoTotal = costoFijo + (long)(usuarios * 500); // $500 COP variable por usuario
            long utilidad   = ingresos - costoTotal;

            String colorUtil = utilidad >= 0 ? VERDE : ROJO;
            String marca = "";
            if (utilidad >= 0 && breakevenMes == -1 && mes > 1) {
                breakevenMes = mes;
                marca = AMARILLO + " ◄ EQUILIBRIO" + RESET;
            }

            System.out.printf("  %3d  │ %10.0f │ %s%15s%s │ %15s │ %s%s%s%s%n",
                    mes, usuarios,
                    CYAN, formatCOP(ingresos), RESET,
                    formatCOP(costoTotal),
                    colorUtil, formatCOP(utilidad), RESET, marca);

            // Siguiente mes
            usuarios = usuarios * (1 + crecimiento / 100.0) * (1 - churn / 100.0);
        }

        double puntaje = breakevenMes == -1 ? 20 :
                         breakevenMes <= 6  ? 100 :
                         breakevenMes <= 9  ? 70  : 45;

        separador();
        if (breakevenMes > 0)
            System.out.println(VERDE + BOLD + "  ✓ Punto de equilibrio: mes " + breakevenMes + RESET);
        else
            System.out.println(ROJO + "  ✗ No alcanza equilibrio en 12 meses. Revisa precios o costos." + RESET);
        System.out.printf("  Puntaje de crecimiento: %s%.0f / 100%s%n", colorPuntaje(puntaje), puntaje, RESET);
        pausa();
        return puntaje;
    }


    //  REPORTE FINAL

    static void reporte() {
        titulo("REPORTE EJECUTIVO — " + nombreProyecto.toUpperCase());

        int modulosEvaluados = (puntajeMercado > 0 ? 1 : 0) + (puntajeTecnico > 0 ? 1 : 0)
                             + (puntajeCostos > 0 ? 1 : 0)  + (puntajeCrecimiento > 0 ? 1 : 0);

        if (modulosEvaluados == 0) {
            System.out.println(AMARILLO + "  Aún no has evaluado ningún módulo." + RESET);
            pausa();
            return;
        }

        System.out.println();
        imprimirBarra("Mercado     (30%)", puntajeMercado);
        imprimirBarra("Técnico     (25%)", puntajeTecnico);
        imprimirBarra("Costos      (20%)", puntajeCostos);
        imprimirBarra("Crecimiento (25%)", puntajeCrecimiento);

        // Puntaje global ponderado
        double total = 0, peso = 0;
        if (puntajeMercado     > 0) { total += puntajeMercado     * 0.30; peso += 0.30; }
        if (puntajeTecnico     > 0) { total += puntajeTecnico     * 0.25; peso += 0.25; }
        if (puntajeCostos      > 0) { total += puntajeCostos      * 0.20; peso += 0.20; }
        if (puntajeCrecimiento > 0) { total += puntajeCrecimiento * 0.25; peso += 0.25; }
        double global = peso > 0 ? total / peso : 0;

        separador();
        System.out.printf("%n  %sPUNTAJE GLOBAL: %.0f / 100%s%n%n",
                colorPuntaje(global) + BOLD, global, RESET);

        String veredicto;
        if      (global >= 75) veredicto = VERDE  + " ALTA VIABILIDAD — ¡Adelante con el MVP!";
        else if (global >= 55) veredicto = AMARILLO + "  VIABILIDAD MEDIA — Valida más antes de invertir.";
        else if (global >= 35) veredicto = AMARILLO + " VIABILIDAD BAJA — Revisa propuesta de valor.";
        else                   veredicto = ROJO    + " NO VIABLE aún — Reconsidera el enfoque.";
        System.out.println("  " + veredicto + RESET);

        System.out.println(CYAN + "\n  Próximos pasos:" + RESET);
        System.out.println("  1. Haz un prototipo en papel o Figma antes de codificar");
        System.out.println("  2. Entrevista al menos 5 usuarios potenciales");
        System.out.println("  3. Construye el MVP con la función más importante primero");
        System.out.println("  4. Lanza, mide y ajusta con usuarios reales");
        pausa();
    }


    //  HELPERS UI

    static void banner() {
        System.out.println(CYAN + BOLD);
        System.out.println(" Evaluador de Ideas");
        System.out.println(" Para Ingeniería de Sistemas ");
        System.out.println(RESET);
    }

    static void menu() {
        System.out.println();
        System.out.println(AZUL + BOLD + "  ═══ MENÚ ══════════════════════════════════════" + RESET);
        System.out.printf("  Proyecto: %s%s%s%n", BOLD, nombreProyecto, RESET);
        System.out.println(AZUL + "  ──" + RESET);
        System.out.println("  " + marcaModulo(puntajeMercado)    + CYAN + "1" + RESET + " → Validación de Mercado");
        System.out.println("  " + marcaModulo(puntajeTecnico)    + CYAN + "2" + RESET + " → Planeación Técnica");
        System.out.println("  " + marcaModulo(puntajeCostos)     + CYAN + "3" + RESET + " → Estimación de Costos");
        System.out.println("  " + marcaModulo(puntajeCrecimiento)+ CYAN + "4" + RESET + " → Simulación de Crecimiento");
        System.out.println("  " + VERDE  + "5" + RESET + " →  Ver Reporte Final");
        System.out.println("  " + ROJO   + "0" + RESET + " → Salir");
        System.out.println(AZUL + "  ──" + RESET);
    }

    static String marcaModulo(double p) {
        if (p <= 0) return "⬜ ";
        if (p >= 70) return VERDE  + "✅ " + RESET;
        if (p >= 45) return AMARILLO + "⚠️  " + RESET;
        return ROJO + "❌ " + RESET;
    }

    static void titulo(String t) {
        System.out.println("\n" + AZUL + BOLD);
        System.out.println("  ┌┐");
        System.out.printf( "  │  %-44s│%n", t);
        System.out.println("  └┘" + RESET);
        System.out.println();
    }

    static void separador() {
        System.out.println(AZUL + "\n  ──" + RESET);
    }

    static void pausa() {
        System.out.print(AMARILLO + "\n  Presiona ENTER para continuar..." + RESET);
        sc.nextLine();
    }

    static void imprimirBarra(String etiqueta, double puntaje) {
        if (puntaje <= 0) {
            System.out.printf("  %-20s  [no evaluado]%n", etiqueta);
            return;
        }
        int llenas = (int)(puntaje / 5);
        String barra = "█".repeat(llenas) + "░".repeat(20 - llenas);
        System.out.printf("  %-20s  %s%s%s  %.0f%n", etiqueta, colorPuntaje(puntaje), barra, RESET, puntaje);
    }

    static String colorPuntaje(double p) {
        if (p >= 70) return VERDE;
        if (p >= 45) return AMARILLO;
        return ROJO;
    }

    static String interpretarPuntaje(double p) {
        if (p >= 80) return VERDE  + "✅ Mercado muy atractivo." + RESET;
        if (p >= 60) return AMARILLO + "⚠️  Mercado interesante, valida más." + RESET;
        if (p >= 40) return AMARILLO + "🔶 Mercado incierto, revisa propuesta." + RESET;
        return ROJO + "❌ Mercado débil, reconsidera." + RESET;
    }

    static String formatCOP(long valor) {
        return String.format("$ %,d", valor).replace(",", ".");
    }

    // Lectura de datos
    static int leerInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(AMARILLO + prompt + RESET);
            try {
                int v = Integer.parseInt(sc.nextLine().trim());
                if (v >= min && v <= max) return v;
                System.out.println(ROJO + "  Ingresa un valor entre " + min + " y " + max + RESET);
            } catch (NumberFormatException e) {
                System.out.println(ROJO + "  Número inválido." + RESET);
            }
        }
    }

    static long leerLong(String prompt) {
        while (true) {
            System.out.print(AMARILLO + prompt + RESET);
            try {
                return Long.parseLong(sc.nextLine().trim().replace(".", "").replace(",", ""));
            } catch (NumberFormatException e) {
                System.out.println(ROJO + "  Número inválido." + RESET);
            }
        }
    }

    static boolean leerSN(String prompt) {
        while (true) {
            System.out.print(AMARILLO + prompt + RESET);
            String r = sc.nextLine().trim().toLowerCase();
            if (r.equals("s") || r.equals("si")) return true;
            if (r.equals("n") || r.equals("no")) return false;
            System.out.println(ROJO + "  Escribe s o n" + RESET);
        }
    }
}
