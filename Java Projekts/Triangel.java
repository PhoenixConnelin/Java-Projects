// Triangel.java

/***********************************************************************************************
Det här är ett program som ska bestämma radien av de cirklar som är inskriven i samt
omskriven kring en viss triangel. Programmet ska även ta emot uppgifter och kunna göra
simpla beräkningar så som att bestämma triangelns area och omkrets och även länfderna av dess
bisektriser. Detta ska programmet göra baserat på givna uppgifter som är inmatade avanvändaren.
***********************************************************************************************/
import java.util.*;
class Triangel
{
	public static void main (String[] args)
	{
		// Inmatningsverktyg
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);

		// Mata in två sidors längder samt mellanliggande vinkel i grader
		System.out.println ("For att finna din triangel behovs 2 langder och ");
		System.out.println ("mellanliggande vinkel. Vanligen mata in dessa.");
		System.out.println ();
		System.out.print ("Sida 1: ");
		double a = in.nextDouble ();
		while (a <= 0)
		{
			System.out.println ();
			System.out.println ("En triangels sida maste vara > 0. "+
			"Ange korrekt langd till Sida 1!");
			System.out.print ("Sida 1: ");
			a = in.nextDouble ();
		}
		System.out.print ("Sida 2: ");
		double b = in.nextDouble ();
		while (b <= 0)
		{
			System.out.println ();
			System.out.println ("En triangels sida maste vara > 0. "+
			"Ange korrekt langd till Sida 2!");
			System.out.print ("Sida 2: ");
			b = in.nextDouble ();
		}
		System.out.print ("Mellanliggande vinkel (i grader): ");
		double v = in.nextDouble ();
		while (v <= 0 || v >= 180)
		{
			System.out.println ();
			System.out.println ("En triangels vinkel maste vara inom intervallet (0 , 180). ");
			System.out.println ("Ange korrekt storlek till den mellanliggande vinkeln!");
			System.out.print ("Mellanliggande vinkel (i grader): ");
			v = in.nextDouble ();
		}
		System.out.println ();

		// Berakning av triangelns sidor och vinklar
		v = Math.toRadians (v);
		final double c = Math.sqrt (a * a + b * b - 2 * a * b * Math.cos (v));
		final double u = Math.toDegrees (Math.acos ((b * b - a * a - c * c) / (-2 * a * c)));
		v = Math.toDegrees (v);
		final double w = 180 - v - u;

		// Visning av triangel
		System.out.println ("Ar detta din triangel? Skriv \"ja\" eller \"nej\"");
		System.out.println ();
		System.out.println ("Sida 1: " + a);
		System.out.println ("Sida 2: " + b);
		System.out.println ("Sida 3: " + c);
		System.out.println ("Vinkeln mellan sida 1 och 2: " + v);
		System.out.println ("Vinkeln mellan sida 1 och 3: " + u);
		System.out.println ("Vinkeln mellan sida 2 och 3: " + w);
		System.out.println ();
		in.nextLine ();
		String s1 = in.nextLine ();
		System.out.println ();
		switch (s1)
		{
			case "ja":
			System.out.println ("Vilken berakning ska goras? Skriv ett av foljande alternativ:");
			System.out.println ("\"area\", \"omkrets\", \"bisektriser\" " +
								"eller \"EnTriangelOchDessCirklar\"");
			System.out.println ("OBS! Svara sa som skrivet ovanstaende.");
			String s2 = in.nextLine ();
			System.out.println ();
			switch (s2)
			{
				case "area":
				double A = area (a, (b * Math.sin(Math.toRadians(v))));
				System.out.println ("Triangelns area: " + A);
				System.exit (0);	// Avsluta programmet helt."
				break;
				case "omkrets":
				double O = omkrets (a, b, c);
				System.out.println ("Triangelns omkrets: " + O);
				System.exit (0);	// Avsluta programmet helt.
				break;
				case "bisektriser":
				double bis1 = bisektris (a, b, v);
				double bis2 = bisektris (a, c, u);
				double bis3 = bisektris (b, c, w);
				System.out.println ("Langderna av bisektriserna ar foljande:");
				System.out.print ("Bisektrisen som delar vinkeln mellan sida 1 och 2: ");
				System.out.println (bis1);
				System.out.print ("Bisektrisen som delar vinkeln mellan sida 1 och 3: ");
				System.out.println (bis2);
				System.out.print ("Bisektrisen som delar vinkeln mellan sida 2 och 3: ");
				System.out.println (bis3);
				System.exit (0);	// Avsluta programmet helt.
				break;
				case "EnTriangelOchDessCirklar":
				double R1 = omskrivenCirkel (a, b, c, (omkrets (a, b, c) / 2));
				double R2 = inskrivenCirkel (a, b, c, (omkrets (a, b, c) / 2));
				System.out.println ("Radien av den omskrivna cirkeln: " + R1);
				System.out.println ("Radien av den inskrivna cirkeln: " + R2);
				System.exit (0);	// Avsluta programmet helt.
				break;
			}
			System.out.println ("Felaktig inmatning. Inget av alternativen valdes.");
			System.out.println ("Starta om programmet och folj instruktionerna.");
			System.out.println ("OBS! Glom inte att kontrollera stavning");
			System.exit (0);	// Avsluta programmet helt.
			break;
			case "nej":
			System.out.println ("Fel varden har angivits. Var god och ");
			System.out.println ("starta om programmet och ange korrekta varden!");
			System.exit (0);
			break;
		}
		System.out.println ("Felaktigt svar. Starta om programmet och prova igen!");
	}
	public static double omkrets (double a, double b, double c)
	{
		// Denna metod beraknar en triangels omkrets och returnerar vardet.
		double O = a + b + c;
		return O;
	}
	public static double area (double B, double h)
	{
		// Denna metod beraknar en triangels area och returnerar vardet.
		double A = B * h / 2;
		return A;
	}
	public static double bisektris (double a, double b, double v)
	{
		//Denna metod beraknar langden av en bisektris och returnerar vardet.
		v = Math.toRadians (v);
		double bis = 2 * a * b * Math.cos (v/2) / (a + b);
		return bis;
	}
	public static double omskrivenCirkel (double a, double b, double c, double s)
	{
		// Denna metod beraknar langden på radien av den cirkel som är omskriven triangeln.
		double r = a * b * c / (4 * Math.sqrt (s * (s - a) * (s - b) * (s - c)));
		return r;
	}
	public static double inskrivenCirkel (double a, double b, double c, double s)
	{
		// Denna metod beraknar langden på radien av den cirkel som är inskriven i triangeln.
		double r = Math.sqrt ((s - a) * (s - b) * (s - c) / s);
		return r;
	}
}