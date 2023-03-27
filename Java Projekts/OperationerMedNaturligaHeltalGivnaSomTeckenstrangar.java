import java.util.*;    // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
    public static void main (String[] args)
    {
        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");

        // mata in två naturliga heltal
        Scanner    in = new Scanner (System.in);
        out.println ("två naturliga heltal:");
        String    tal1 = in.next ();
        while (kontroll (tal1) == false)
        {
			out.println (tal1 + " är inte ett naturligt tal. Ange ett naturligt tal");
			tal1 = in.next ();
		}

        String    tal2 = in.next ();
        while (kontroll (tal2) == false)
		{
			out.println (tal1 + " är inte ett naturligt tal. Ange ett naturligt tal");
        	tal2 = in.next ();
		}

        out.println ();

        // finn korrekt ordning
        if (mindre (tal1, tal2) == 1)
        {
			String tal = tal2;
			tal2 = tal1;
			tal1 = tal;
		}

        // addera heltalen och visa resultatet
        String    summa = addera (tal1, tal2);
        visa (tal1, tal2, summa, '+');

        // subtrahera heltalen och visa resultatet
        String    differens = subtrahera (tal1, tal2);
        visa (tal1, tal2, differens, '-');
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2)
    {
        int t = 0;
        char c = 0;

        StringBuilder sb = new StringBuilder ();

        for (int i = 1; i <= Math.min (tal1.length (), tal2.length ()); i++)
        {
			c = (char) (tal1.charAt (tal1.length () - i) + tal2.charAt (tal2.length () - i) - 48 + t);
			t = 0;
			if (c > 57)
			{
				c = (char) (c - 10);
				t = 1;
			}
			sb.insert (0, c);
		}

		if (tal1.length () > Math.min (tal1.length (), tal2.length ()))
		{
			for (int i = tal2.length () + 1; i <= tal1.length (); i++)
			{
				c = (char) (tal1.charAt (tal1.length () - i) + t);
				t = 0;
				if (c > 57)
				{
					c = (char) (c - 10);
					t = 1;
				}
				sb.insert (0, c);
			}
		}
		if (tal2.length () > Math.min (tal1.length (), tal2.length ()))
		{
			for (int i = tal1.length () + 1; i <= tal2.length (); i++)
			{
				c = (char) (tal2.charAt (tal2.length () - i) + t);
				t = 0;
				if (c > 57)
				{
					c = (char) (c - 10);
					t = 1;
				}
				sb.insert (0, c);
			 }
		 }
		 if (t == 1)
		 sb.insert (0, '1');

        String summa = sb.toString ();
        return summa;
    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera (String tal1, String tal2)
    {
        // koden ska skrivas här

        int t = 0;
        char c = 0;

		StringBuilder sb = new StringBuilder ();

		for (int i = 1; i <= tal2.length (); i++)
		{
			c = (char) (t + 48 + tal1.charAt (tal1.length () - i) - tal2.charAt (tal2.length () - i));
			if (c < 48)
			{
				t = -1;
				c = (char) (c + 10);
			}
			else
			t = 0;

			sb.insert (0, c);
		}

		for (int i = tal2.length () + 1; i <= tal1.length (); i++)
		{
			c = (char) (t + tal1.charAt (tal1.length () - i));
			if (t == -1)
			{
				if (c < 48)
				c = (char) (c + 10);
				else
				t = 0;
			}

			sb.insert (0, c);
		}
		while (sb.charAt (0) == (char) 48)
		{
			if (sb.length () > 1)
			sb.deleteCharAt (0);
			else
			break;
		}

		String differens = sb.toString ();
        return differens;
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
	public static void visa (String tal1, String tal2, String resultat, char operator)
    {
        // sätt en lämplig längd på heltalen och resultatet
        int    len1 = tal1.length ();
        int    len2 = tal2.length ();
        int    len  = resultat.length ();
        int    maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen - len1);
        tal2 = sattLen (tal2, maxLen - len2);
		resultat = sattLen (resultat, maxLen - len);

		// visa heltalen och resultatet
		out.println ("  " + tal1);
		out.println ("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
		out.print ("-");
		out.println ();
		out.println ("  " + resultat + "\n");
	}

	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen (String s, int antal)
	{
       StringBuilder    sb = new StringBuilder (s);
       for (int i = 0; i < antal; i++)
       sb.insert (0, " ");

	   return sb.toString ();
	}

	// Denna metod anger det mindre talet av de angivna talen
	public static int mindre (String tal1, String tal2)
	{
		int t = 0;

		if (tal1.length () < tal2.length ())
		t = 1;

		if (tal2.length () < tal1.length ())
		t = 2;

		if (tal1.length () == tal2.length ())
		{
			for (int i = 0; i < tal1.length (); i++)
			{
				if ((48 + tal1.charAt (i) - tal2.charAt (i)) < 48)
				{
					t = 1;
					break;
				}
				if ((48 + tal2.charAt (i) - tal1.charAt (i)) < 48)
				{
					t = 2;
					break;
				}
			}
		}

		return t;
	}

	public static boolean kontroll (String tal)
	{
		for (int i = 0; i < tal.length (); i++)
		if (tal.charAt (i) < 48 || tal.charAt (i) > 57)
		return false;

		return true;
	}
}