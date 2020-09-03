package main;

public class Question3 {

	private static Question3 question3;// private singleton nesnemiz

	private Question3() { // Class'ýmýzý singleton ile oluþturduk 

	}

	public static Question3 getInstance() {// Class'ýmýzýn nesne aldýðýmýz methodu
		if (question3 == null) {
			return question3 = new Question3();
		}

		return question3;
	}

	public int SumForMe(int a, int b) {
		System.out.println("3.Soru aritmetik operatörler olmadan toplama iþlemi yapýlýyor.");
		int result;// sonuc için int deðiþken tanýmladým
		try {
			if (a < 0 || b < 0) {// sayýlar negatif olmamasý için kontrol koydum
				throw new RuntimeException("Sayýlar negatif olamaz!");
			}
			if (a == 0 && b != 0) {// birisi 0 diðeri deðil ise sonuç 0 olmayan deðer oluyor
				result = b;
			} else if (b == 0 && a != 0) {// birisi 0 diðeri deðil ise sonuç 0 olmayan deðer oluyor
				result = a;
			} else if (b == 0 && a == 0) { // iki sayý da 0 ise sonuç 0
				result = 0;
			} else {
				while (b != 0) { // elde sayýsý kalmayana kadar döngü içinde devam ediyoruz
					int elde = a & b; // elde sayýsýný bulmak için and iþlemine sokuyoruz
					a = a ^ b; // burda xor iþlemine sokarak elde olmadan toplama iþlemi yapmýþ oluyoruz
					b = elde << 1;// sonucumuza elde sayýmýzý da shift ederek varsa sonraki döngüye yoksa return e
									// dönüyoruz
				}

				result = a;
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile karþýlaþtým! > " + e);
		}
		return result;
	}

}
