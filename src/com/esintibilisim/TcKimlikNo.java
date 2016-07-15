package com.esintibilisim;

public class TcKimlikNo {

	public static Boolean Dogrula(String tckimlik) {
		if (tckimlik.length() != 11)
			return false;
		
		if (tckimlik.charAt(0) == '0')
			return false;

		int[] hane = new int[11];
		int toplam = 0;
		for (int i = 0; i < 11; i++) {
			hane[i] = Integer.parseInt(String.valueOf(tckimlik.charAt(i)));
			toplam += hane[i];
		}
		toplam -= hane[10];
		if ((toplam % 10) != hane[10])
			return false;

		int ciftler = hane[0] + hane[2] + hane[4] + hane[6] + hane[8];
		int tekler = hane[1] + hane[3] + hane[5] + hane[7];

		if (((ciftler * 7) + (tekler * 9)) % 10 != hane[9])
			return false;
		if ((ciftler * 8) % 10 != hane[10])
			return false;

		return true;
	}

	private static String Tamamla(String tckimlik) {
		tckimlik = tckimlik.trim().substring(0,9);
		int[] hane = new int[9];
		for (int i = 0; i < hane.length; i++) {
			hane[i] = Integer.parseInt(String.valueOf(tckimlik.charAt(i)));
		}
		
		int ciftler = hane[0] + hane[2] + hane[4] + hane[6] + hane[8];
		int tekler = hane[1] + hane[3] + hane[5] + hane[7];
		
		int hane10 = ((ciftler * 7) + (tekler * 9)) % 10;
		int hane11 = (ciftler * 8) % 10;
		
		return tckimlik + hane10 + hane11;
	}

	public static String AkrabaBul(String tckimlik, String yon) {
		String ilk5 = tckimlik.substring(0,5);
		String son4 = tckimlik.substring(5,9);
		
		if (yon.equals("+")) {
			ilk5 = String.valueOf( Integer.parseInt(ilk5) + 6);
			son4 = String.valueOf( Integer.parseInt(son4) - 2);
		} else {
			ilk5 = String.valueOf( Integer.parseInt(ilk5) - 6);
			son4 = String.valueOf( Integer.parseInt(son4) + 2);
		}
		
		return Tamamla(ilk5 + son4);
	}

}
