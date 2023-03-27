/***************************************************************************************

Problem: Skapa en algoritm som hittar den kortaste distansen med start i staion X och
slut i station Y, samt passerar en station i vardera mellan-zon.

Förvilkor:
a[i], b[i][j], c[j] > 0
1 <= i <= m, m >= 1, m "tillhör" N (de naturliga talen)
1 <= j <= n, n >= 1, n "tillhör" N (de naturliga talen)

X, Y, U[i] och V[j] är stationernas namn och dessa ligger i var sin zon, där X ligger i
Z1 (zon 1), U[i] i Z2, V[j] i Z3 och Y i Z4.

Eftervilkor:
Den kortaste distansen. Denna distans > 0
Den eftersökta resan med strukturen: X -> U[p] -> V[q] -> Y, där p och q är indexet för
de valen av mellanstationer som ger den kortaste distansen. p "tillhör" [1, m] och
q "tillhör" [1, n].

***************************************************************************************/
import java.util.*;
class BestamDenKortasteVagen
{
	public static void main (String[] args)
	{
		// Inmatningsverktyg
		Scanner	in = new Scanner (System.in);
		in.useLocale (Locale.US);

		// Mata in antalet stationer i zonerna
		System.out.println ("I Zon-1 finns det 1 station, X. " +
		                     "I Zon-4 finns det 1 station, Y.");
		System.out.println ("Ange antalet stationer i de andra stationerna");
		System.out.print ("Zon-2: ");
		int i = in.nextInt ();
		while (i < 1)
		{
			System.out.println ("Antalet stationer ska vara ett positivt heltal!");
			System.out.println ("Ange antalet stationer i de andra stationerna");
			System.out.print ("Zon-2: ");
			i = in.nextInt ();
		}
		System.out.print ("Zon-3: ");
		int j = in.nextInt ();
		while (j < 1)
		{
			System.out.println ("Antalet stationer ska vara ett positivt heltal!");
			System.out.println ("Ange antalet stationer i zonen");
			System.out.print ("Zon-3: ");
			j = in.nextInt ();
		}
		System.out.println ();

		// Skapa vektorer som ska lagra data om distanserna mellan stationerna
		double[] a = new double[i + 1];
		double[][] b = new double[i + 1][j + 1];
		double[] c = new double[j + 1];

		// Mata in distanserna mellan stationerna
		System.out.println ("Mata in distanserna mellan stationerna");
		for (int m = 1; m <= i; m++)
		{
			System.out.print ("Distansen mellan stationerna X och U" + m + ": ");
			a[m] = in.nextDouble ();
			while (a[m] <= 0)
			{
				System.out.println ("Distansen ska vara ett positivt tal och noll-skiljt!");
				System.out.println ("Mata in korrekta distanser!");
				System.out.print ("Distansen mellan stationerna X och U" + m + ": ");
				a[m] = in.nextDouble ();
			}
		}
		for (int m = 1; m <= i; m++)
		{
			for (int n = 1; n <= j; n++)
			{
				System.out.print ("Distansen mellan stationerna U" + m + " och V" + n + ": ");
				b[m][n] = in.nextDouble ();
				while (b[m][n] <= 0)
				{
					System.out.println ("Distansen ska vara ett positivt tal och noll-skiljt!");
					System.out.println ("Mata in korrekta distanser!");
					System.out.print ("Distansen mellan stationerna U" + m + " och V" + n + ": ");
					b[m][n] = in.nextDouble ();
				}
			}
		}
		for (int n = 1; n <= j; n++)
		{
			System.out.print ("Distansen mellan stationerna V" + n + " och Y: ");
			c[n] = in.nextDouble ();
			while (c[n] <= 0)
			{
				System.out.println ("Distansen ska vara ett positivt tal och noll-skiljt!");
				System.out.println ("Mata in korrekta distanser!");
				System.out.print ("Distansen mellan stationerna V" + n + " och Y: ");
				c[n] = in.nextDouble ();
			}
		}
		System.out.println ();

		// Anropa klassen DenKortasteVagen som finner stationerna som ger den kortaste
		// distansen samt den kortaste distansen

		int[] val = new int [3];
		val = DenKortasteVagen.mellanstationer (a, b, c);
		double len = DenKortasteVagen.langd (a, b, c);

		// Presentera resultatet
		System.out.println ("Den kortaste distansen ges genom att resa mellan stationerna:");
		System.out.println ("X -> U" + val[1] + " -> V" + val[2] + " -> Y");
		System.out.println ("Denna resa har distansen: " + len);
	}
}