import java.util.*;     // Scanner, Locale
class Temperaturer
{
	public static void main (String[] args)
	{
		System.out.println ("TEMPERATURER\n");

		// inmatningsverktyg
		Scanner    in = new Scanner (System.in);
		in.useLocale (Locale.US);

		// mata in uppgifter om antalet veckor och antalet mätningar
		System.out.print ("antalet veckor: ");
		int    antalVeckor = in.nextInt ();
		while (antalVeckor <= 0)
		{
			System.out.println ("Antalet veckor ska vara > 0 om matningar ska ha gjorts");
			System.out.print ("Ange antalet veckor: ");
			antalVeckor = in.nextInt ();
		}
		System.out.print ("antalet matningar per vecka: ");
		int    antalMatningarPerVecka = in.nextInt ();
		while (antalMatningarPerVecka < 0)
		{
			System.out.println ("Antalet matningar per vecka kan inte vara ett negativt tal");
			System.out.print ("Ange antalet matningar per vecka: ");
			antalMatningarPerVecka = in.nextInt ();
		}
		if (antalMatningarPerVecka == 0)
		{
			System.out.println ("Inga matningar har gjorts och darfor kan inga berakningar utforas");
			System.exit (0);
		}

		// plats att lagra temperaturer
		double[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];

		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.println ("temperaturer -vecka " + vecka + ":");
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			t[vecka][matning] = in.nextDouble ();
		}
		System.out.println ();

		// visa temperaturerna
		System.out.println ("temperaturerna:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			System.out.print (t[vecka][matning] + " ");
			System.out.println ();
		}
		System.out.println ();
		// den minsta,den st�rsta och medeltemperaturen�veckovis
		double[]    minT = new double[antalVeckor + 1];
		double[]    maxT = new double[antalVeckor + 1];
		double[]    sumT = new double[antalVeckor + 1];
		double[]    medelT = new double[antalVeckor + 1];
		// koden ska skrivas h�r!
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			minT[vecka] = t[vecka][1];
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			minT[vecka] = (minT[vecka] < t[vecka][matning])? minT[vecka] : t[vecka][matning];
		}
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			maxT[vecka] = t[vecka][1];
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			maxT[vecka] = (maxT[vecka] > t[vecka][matning])? maxT[vecka] : t[vecka][matning];
		}
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
			{
				sumT[vecka] = sumT[vecka] + t[vecka][matning];
			}
			medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
		}


		// visa den minsta, den st�rsta och medeltemperaturen f�r varje vecka
		// koden ska skrivas h�r
		System.out.println ("De minsta temperaturerna veckovis ar:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.print ("Vecka " + vecka + ": " + minT[vecka]);
			System.out.println ();
		}
		System.out.println ("De hogsta temperaturerna veckovis ar:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.print ("Vecka " + vecka + ": " + maxT[vecka]);
			System.out.println ();
		}
		System.out.println ("Medeltemperaturerna veckovis ar:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		{
			System.out.print ("Vecka " + vecka + ": " + medelT[vecka]);
			System.out.println ();
		}

		// den minsta, den största och medeltemperaturen -helamätperioden
		double    minTemp = minT[1];
		double    maxTemp = maxT[1];
		double    sumTemp = 0;
		double    medelTemp = 0;
		// koden ska skrivas h�r
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		minTemp = (minTemp < minT[vecka])? minTemp : minT[vecka];
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		maxTemp = (maxTemp > maxT[vecka])? maxTemp : maxT[vecka];
		for (int vecka = 1; vecka <= antalVeckor; vecka++)
		sumTemp = sumTemp + sumT[vecka];
		medelTemp = sumTemp / (antalVeckor * antalMatningarPerVecka);

		// visa den minsta, den st�rsta och medeltemperaturen i hela m�tperioden
		//koden ska skrivas h�r
		System.out.println ("Den minsta uppmatta temperaturen ar: " + minTemp);
		System.out.println ("Den hogsta uppmatta temperaturen ar: " + maxTemp);
		System.out.println ("Medeltemperaturen av alla matningar ar: " + medelTemp);
	}
}