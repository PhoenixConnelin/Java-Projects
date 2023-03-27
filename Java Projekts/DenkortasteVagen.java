class DenKortasteVagen
{
	public static int[] mellanstationer (double[] a, double[][] b, double[] c)
	{
		double min = a[1] + b[1][1] + c[1];
		int[] stationer = new int[3];
		stationer[1] = 1;
		stationer[2] = 1;

		for (int i = 1; i <= a.length - 1; i++)
		{
			for (int j = 1; j <= b[1].length - 1; j++)
			{
				if (a[i] + b[i][j] + c[j] < min)
				{
					min = a[i] + b[i][j] + c[j];
					stationer[1] = i;
					stationer[2] = j;
				}
			}
		}

		return stationer;
	}

	public static double langd (double[] a, double[][] b, double[] c)
	{
		double min = a[1] + b[1][1] + c[1];

		for (int i = 1; i <= a.length - 1; i++)
		{
			for (int j = 1; j <= b[1].length - 1; j++)
			{
				if (a[i] + b[i][j] + c[j] < min)
				{
					min = a[i] + b[i][j] + c[j];
				}
			}
		}

		return min;
	}
}