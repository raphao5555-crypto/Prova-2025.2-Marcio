import java.util.Random;
import java.util.Scanner;
public class Atvd01 {
    public static Random gerador = new Random(7);
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] va = new int[15];
        int[] vb = new int[10];
        int[] vu = new int[25];

        preencherRandom(va);
        preencherRandom(vb);
        System.out.println("======VETORES======");
        System.out.println("\nVetor A");
        imprimirVetor(va, va.length);
        System.out.println("\nVetor B");
        imprimirVetor(vb, vb.length);
        System.out.println("\n=======UNIÃO========");
        uniao(va, va.length, vb, vb.length, vu);
        System.out.println("\n========Sem Repetição======");
        gerarVetorSemRepeticao(va, va.length, vu);
        System.out.println("=========ROTACIONAR=========");
        System.out.println("Digite um número pra rotacionar");
        int k = input.nextInt();
        rotacionar(va, va.length, k);

        
    }

    public static void preencherRandom(int[] v) {
        for (int i = 0; i < v.length; i += 1) {
            v[i] = gerador.nextInt(10);
            
        }
    }

/*==================LETRA A================================ */

    public static int uniao (int[] a, int tamA, int[] b, int tamB, int[] u) {
        int x = 0;
        
        x = preencherUniao(a, tamA, u, x);
        x = preencherUniao(b, tamB, u, x);
        System.out.println(x);
        imprimirVetor(u, x);
        
        return x;
        
    }

    public static int preencherUniao (int[] v, int TAM, int[] u, int x) {
        for (int i = 0; i < TAM; i += 1) {
            if (verificar(u, x, v[i])) {
                u[x] = v[i];
                x += 1;
            }
        }
        return x;

    }

    public static boolean verificar(int[] v, int x, int z) {
        for (int i = 0; i < x; i += 1) {
            if (v[i] == z) {
                return false;
            }
        }

        return true;
    }

/*======================LETRA B=================== */
public static void insertionSort(int[] v, int tam) {
        for (int i = 1; i < tam; i += 1) {
            int chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = chave;
        }
    }

/*======================LETRA C ===================== */

public static int gerarVetorSemRepeticao (int[] v, int tamV, int[] vsr) {
    int x = 0;
    for (int i = 0; i < tamV; i += 1) {
        if (verificar(vsr, x, v[i])) {
            vsr[x] = v[i];
            x += 1;
        }
    }
    imprimirVetor(vsr, x);
    return x;
}
/*===========LETRA D================= */

    public static void rotacionar(int[] v, int tam, int k) {
        if (k > 0) {
            rotacaoParaEsquerda(v, tam, k);
        } else {
            rotacaoParaDireita(v, tam, k);
        }

        imprimirVetor(v, tam);

    }

    public static void rotacaoParaEsquerda(int[] v, int tam, int k) {

        while (k > 0) { 
            int aux = v[0];
            for (int i = 0; i < tam; i += 1) {
                if (i == tam - 1) {
                    v[i] = aux;

                } else {
                    v[i] = v[i + 1];
                }
            }
            k -= 1;
        }

    }

    public static void rotacaoParaDireita(int[] v, int tam, int k) {
        while (k < 0) {
        int aux = v[tam - 1];
            for (int i = tam - 1; i >= 0; i -= 1) {   
                if (i == 0) {
                    v[i] = aux;
                } else {
                    v[i] = v[i - 1];
                }
            }
            k += 1;
        }

    }


    public static void imprimirVetor(int[] v, int tam) {
        for (int i = 0; i < tam; i += 1) {
            if (v[i] < 10) {
                System.out.print("0");
            }
            System.out.printf("%d ", v[i]);
        }
    }
}
