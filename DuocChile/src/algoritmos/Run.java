package algoritmos;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
	
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		Guia1 g1 = new Guia1();
		Guia2 g2 = new Guia2();
		Guia3 g3 = new Guia3();
		System.out.println();
		
		/*
		System.out.println(g3.g3e1());
		System.out.println("******");
		System.out.println(g3.g3e2(-20, -30));
		System.out.println("******");
		System.out.println(g3.g3e3());
		System.out.println("******");
		System.out.println(g3.g3e4());
		System.out.println("******");
		
		*/
		//System.out.println(g3.g3e2(1,-18));
	char[] g = {'m','m','f','f','f','f','f','m','m','f'};
	int[] e = {18,18,20,25,27,19,23,45,21,35};
	
	
	}
	
	public static void ordenandoMatriz() {
		
		Guia2 g2 = new Guia2();
		float[][] x = { { 1f, 2f, 3f }, { 1f, 3f, 2f }, { 2f, 1f, 3f }, { 2f, 3f, 1f }, { 3f, 1f, 2f },	{ 3f, 2f, 1f } };
		
		float[] x1 = { 1f, 2f, 3f };
		float[] x2 = { 1f, 3f, 2f };
		float[] x3 = { 2f, 1f, 3f };
		float[] x4 = { 2f, 3f, 1f };
		float[] x5 = { 3f, 1f, 2f };
		float[] x6 = { 3f, 2f, 1f };

		System.out.println(g2.g2e19(x1)[0]+", "+g2.g2e19(x1)[1]+", "+g2.g2e19(x1)[2]);
		System.out.println(g2.g2e19(x2)[0]+", "+g2.g2e19(x2)[1]+", "+g2.g2e19(x2)[2]);
		System.out.println(g2.g2e19(x3)[0]+", "+g2.g2e19(x3)[1]+", "+g2.g2e19(x3)[2]);
		System.out.println(g2.g2e19(x4)[0]+", "+g2.g2e19(x4)[1]+", "+g2.g2e19(x4)[2]);
		System.out.println(g2.g2e19(x5)[0]+", "+g2.g2e19(x5)[1]+", "+g2.g2e19(x5)[2]);
		System.out.println(g2.g2e19(x6)[0]+", "+g2.g2e19(x6)[1]+", "+g2.g2e19(x6)[2]);
	}
}
