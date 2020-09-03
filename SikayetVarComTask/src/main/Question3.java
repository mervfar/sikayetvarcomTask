package main;

public class Question3 {

	private static Question3 question3;// private singleton nesnemiz

	private Question3() { // Class'�m�z� singleton ile olu�turduk

	}

	public static Question3 getInstance() {// Class'�m�z�n nesne ald���m�z methodu
		if (question3 == null) {
			return question3 = new Question3();
		}

		return question3;
	}

	public int SumForMe(int a, int b) {
		System.out.println("3.Soru aritmetik operat�rler olmadan toplama i�lemi yap�l�yor.");
		int result;// sonuc i�in int de�i�ken tan�mlad�m
		try {
			if (a < 0 || b < 0) {// say�lar negatif olmamas� i�in kontrol koydum
				throw new RuntimeException("Say�lar negatif olamaz!");
			}
			if (a == 0 && b != 0) {// birisi 0 di�eri de�il ise sonu� 0 olmayan de�er oluyor
				result = b;
			} else if (b == 0 && a != 0) {// birisi 0 di�eri de�il ise sonu� 0 olmayan de�er oluyor
				result = a;
			} else if (b == 0 && a == 0) { // iki say� da 0 ise sonu� 0
				result = 0;
			} else {
				while (b != 0) { // elde say�s� kalmayana kadar d�ng� i�inde devam ediyoruz
					int elde = a & b; // elde say�s�n� bulmak i�in and i�lemine sokuyoruz
					a = a ^ b; // burda xor i�lemine sokarak elde olmadan toplama i�lemi yapm�� oluyoruz
					b = elde << 1;// sonucumuza elde say�m�z� da shift ederek varsa sonraki d�ng�ye yoksa return e
									// d�n�yoruz
				}

				result = a;
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile kar��la�t�m! > " + e);
		}
		return result;
	}

}
