package main;

public class Question3 {

	private static Question3 question3;// private singleton nesnemiz

	private Question3() { // Class'imizi singleton ile olusturduk 

	}

	public static Question3 getInstance() {// Class'imizin nesne aldigimiz methodu
		if (question3 == null) {
			return question3 = new Question3();
		}

		return question3;
	}

	public int SumForMe(int a, int b) {
		System.out.println("3.Soru aritmetik operatörler olmadan toplama islemi yapiliyor.");
		int result;// sonuc için int degisken tanimladim
		try {
			if (a < 0 || b < 0) {// sayilar negatif olmamasi icin kontrol koydum
				throw new RuntimeException("Sayilar negatif olamaz!");
			}
			if (a == 0 && b != 0) {// birisi 0 digeri degil ise sonuc 0 olmayan deger oluyor
				result = b;
			} else if (b == 0 && a != 0) {// birisi 0 digeri degil ise sonuc 0 olmayan deger oluyor
				result = a;
			} else if (b == 0 && a == 0) { // iki sayi da 0 ise sonuc 0
				result = 0;
			} else {
				while (b != 0) { // elde sayisi kalmayana kadar dongu icinde devam ediyoruz
					int elde = a & b; // elde sayisini bulmak icin and islemine sokuyoruz
					a = a ^ b; // burda XOR islemine sokarak elde olmadan toplama islemi yapmis oluyoruz
					b = elde << 1;// sonucumuza elde sayimizi da shift ederek varsa sonraki donguye yoksa return e
									// donuyoruz
				}

				result = a;
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile karsilastim! > " + e);
		}
		return result;
	}

}
