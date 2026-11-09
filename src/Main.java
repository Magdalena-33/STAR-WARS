import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int MAX_FIL_YODA = 10;
        int MAX_COL_YODA = 10;
        int MAX_FIL_DM = 10;
        int MAX_COL_DM = 10;
        char YODA = 'Y';
        char LIBRE = 'L';
        char DM = 'D';
        char MURO = 'M';
        char VADER = 'V';
        char POCIMA = 'P';
        boolean yodaActive = true;
        boolean dmActive = false;
        // NO VOY A UTILIZAR FUNCIONES/PROCEDIMIENTOS
        char[][] tableroYoda = new char[MAX_FIL_YODA][MAX_COL_YODA];
        char[][] tableroDM = new char[MAX_FIL_DM][MAX_COL_DM];
        Random aleat = new Random();
        int filaAl = -1;
        int colAl = -1;

        // ================= TABLERO YODA =================
        for (int i = 0; i < MAX_FIL_YODA; i++) {
            for (int j = 0; j < MAX_COL_YODA; j++) {
                tableroYoda[i][j] = LIBRE;
            }
        }
        // 1 YODA
        do {
            filaAl = aleat.nextInt(MAX_FIL_YODA);
            colAl = aleat.nextInt(MAX_COL_YODA);
        } while (tableroYoda[filaAl][colAl] != LIBRE);
        tableroYoda[filaAl][colAl] = YODA;
        // OFICIALIZO LAS POSICIONES DE MI YODA
        int filaOficialYoda = filaAl;
        int columnaOficialYoda = colAl;
        // FIN
        for (int i = 0; i < 10; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroYoda[filaAl][colAl] != LIBRE);
            tableroYoda[filaAl][colAl] = MURO;
        }
        for (int i = 0; i < 7; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroYoda[filaAl][colAl] != LIBRE);
            tableroYoda[filaAl][colAl] = VADER;
        }
        for (int i = 0; i < 5; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroYoda[filaAl][colAl] != LIBRE);
            tableroYoda[filaAl][colAl] = POCIMA;
        }

        // ================= TABLERO DM =================
        for (int i = 0; i < MAX_FIL_DM; i++) {
            for (int j = 0; j < MAX_COL_DM; j++) {
                tableroDM[i][j] = LIBRE;
            }
        }
        // 1 DM
        do {
            filaAl = aleat.nextInt(MAX_FIL_DM);
            colAl = aleat.nextInt(MAX_COL_DM);
        } while (tableroDM[filaAl][colAl] != LIBRE);
        tableroDM[filaAl][colAl] = DM;
        // OFICIALIZO LAS POSICIONES DE MI DM
        int filaOficialDM = filaAl;
        int columnaOficialDM = colAl;
        // FIN
        for (int i = 0; i < 10; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_DM);
                colAl = aleat.nextInt(MAX_COL_DM);
            } while (tableroDM[filaAl][colAl] != LIBRE);
            tableroDM[filaAl][colAl] = MURO;
        }
        for (int i = 0; i < 7; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_DM);
                colAl = aleat.nextInt(MAX_COL_DM);
            } while (tableroDM[filaAl][colAl] != LIBRE);
            tableroDM[filaAl][colAl] = VADER;
        }
        for (int i = 0; i < 5; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_DM);
                colAl = aleat.nextInt(MAX_COL_DM);
            } while (tableroDM[filaAl][colAl] != LIBRE);
            tableroDM[filaAl][colAl] = POCIMA;
        }

        int vidasYoda = 10;
        int vidasDM = 10;
        Scanner lector = new Scanner(System.in);
        System.out.println("EMPIEZA EL JUEGO!!");

        do {
            if (yodaActive && !dmActive) {

                System.out.println("TABLERO YODA (vidas: " + vidasYoda + ")");
                for (int fila = 0; fila < MAX_FIL_YODA; fila++) {
                    for (int columna = 0; columna < MAX_COL_YODA; columna++) {
                        System.out.print(tableroYoda[fila][columna] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Tablero Yoda");
                System.out.println("Te mueves en WASD");
                System.out.println("Dime una letra de movimiento !!");
                char mov = lector.next().charAt(0);
                int filaAnteriorYoda = filaOficialYoda;
                int colAnteriorYoda = columnaOficialYoda;
                switch (mov) { // W, A, S o D
                    case 'W':
                        filaOficialYoda = filaOficialYoda - 1;
                        break;
                    case 'A':
                        columnaOficialYoda = columnaOficialYoda - 1;
                        break;
                    case 'S':
                        filaOficialYoda = filaOficialYoda + 1;
                        break;
                    case 'D':
                        columnaOficialYoda = columnaOficialYoda + 1;
                        break;
                }
                // Y SI YODA SE SALE DEL TABLERO ??????????????????
                if (filaOficialYoda < 0 ||
                        filaOficialYoda > 9 ||
                        columnaOficialYoda < 0 ||
                        columnaOficialYoda > 9) {
                    System.out.println("EHHHHHHHH!!!!!!!!!!!!");
                    System.out.println("LÍMITE DE TABLERO!!!!!!");
                    filaOficialYoda = filaAnteriorYoda;
                    columnaOficialYoda = colAnteriorYoda;
                } else {
                    if (tableroYoda[filaOficialYoda][columnaOficialYoda] == MURO) {
                        System.out.println("NO PUEDES PASAR!!!!!");
                        filaOficialYoda = filaAnteriorYoda;
                        columnaOficialYoda = colAnteriorYoda;
                    } else if (tableroYoda[filaOficialYoda][columnaOficialYoda] == POCIMA) {
                        tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                        tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                        vidasYoda++;
                    } else if (tableroYoda[filaOficialYoda][columnaOficialYoda] == VADER) {
                        tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                        tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                        vidasYoda--;
                    } else if (tableroYoda[filaOficialYoda][columnaOficialYoda] == LIBRE) {
                        tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                        tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                    }
                }
                // CAMBIO DE TABLERO
                yodaActive = false;
                dmActive = true;
            } else {
                System.out.println("TABLERO DM (vidas: " + vidasDM + ")");
                for (int fila = 0; fila < MAX_FIL_DM; fila++) {
                    for (int columna = 0; columna < MAX_COL_DM; columna++) {
                        System.out.print(tableroDM[fila][columna] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Tablero DM");
                System.out.println("Te mueves con WASD");
                System.out.println("Dime una letra de movimiento !!");
                char mov = lector.next().charAt(0);
                int filaAnteriorDM = filaOficialDM;
                int colAnteriorDM = columnaOficialDM;
                switch (mov) { // W, A, S o D
                    case 'W':
                        filaOficialDM = filaOficialDM - 1;
                        break;
                    case 'A':
                        columnaOficialDM = columnaOficialDM - 1;
                        break;
                    case 'S':
                        filaOficialDM = filaOficialDM + 1;
                        break;
                    case 'D':
                        columnaOficialDM = columnaOficialDM + 1;
                        break;
                }
                // Y SI DM SE SALE DEL TABLERO ??????????????????
                if (filaOficialDM < 0 ||
                        filaOficialDM > 9 ||
                        columnaOficialDM < 0 ||
                        columnaOficialDM > 9) {
                    System.out.println("EHHHHHHHH!!!!!!!!!!!!");
                    System.out.println("LÍMITE DE TABLERO!!!!!!");
                    filaOficialDM = filaAnteriorDM;
                    columnaOficialDM = colAnteriorDM;
                } else {
                    if (tableroDM[filaOficialDM][columnaOficialDM] == MURO) {
                        System.out.println("NO PUEDES PASAR!!!!!");
                        filaOficialDM = filaAnteriorDM;
                        columnaOficialDM = colAnteriorDM;
                    } else if (tableroDM[filaOficialDM][columnaOficialDM] == POCIMA) {
                        tableroDM[filaOficialDM][columnaOficialDM] = DM;
                        tableroDM[filaAnteriorDM][colAnteriorDM] = LIBRE;
                        vidasDM++;
                    } else if (tableroDM[filaOficialDM][columnaOficialDM] == VADER) {
                        tableroDM[filaOficialDM][columnaOficialDM] = DM;
                        tableroDM[filaAnteriorDM][colAnteriorDM] = LIBRE;
                        vidasDM--;
                    } else if (tableroDM[filaOficialDM][columnaOficialDM] == LIBRE) {
                        tableroDM[filaOficialDM][columnaOficialDM] = DM;
                        tableroDM[filaAnteriorDM][colAnteriorDM] = LIBRE;
                    }
                }
                // CAMBIO DE TABLERO
                yodaActive = true;
                dmActive = false;
            }
        } while (vidasYoda > 0 && vidasDM > 0);

        // FIN DEL JUEGO: SE MUESTRAN LOS DOS TABLEROS
        System.out.println("FIN DEL JUEGO");
        System.out.println("TABLERO YODA");
        for (int fila = 0; fila < MAX_FIL_YODA; fila++) {
            for (int columna = 0; columna < MAX_COL_YODA; columna++) {
                System.out.print(tableroYoda[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println("TABLERO DM");
        for (int fila = 0; fila < MAX_FIL_DM; fila++) {
            for (int columna = 0; columna < MAX_COL_DM; columna++) {
                System.out.print(tableroDM[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}