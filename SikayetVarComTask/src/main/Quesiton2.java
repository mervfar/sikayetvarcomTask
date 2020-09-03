package main;

public class Quesiton2 {

	private static Quesiton2 question2;// private singleton nesnemiz

	private Quesiton2() { // Class'�m�z� singleton ile olu�turduk

	}

	public static Quesiton2 getInstance() {// Class'�m�z�n nesne ald���m�z methodu
		if (question2 == null) {
			return question2 = new Quesiton2();
		}

		return question2;
	}

	public boolean isUniq(String str) {
		System.out.println("2.Soru array vs. kullan�lmadan ��z�m �retildi.");
		try {
			if (str.matches(".*\\d+.*")) { // regex ile say� tespit ediyoruz
				throw new RuntimeException("Girilen string numara veya rakam i�eriyor!");
			}
			if (str.matches(".*\\p{Punct}.*")) {// regex ile noktlama i�aretleri tespiti
				throw new RuntimeException("Girilen string noktalama i�aretleri i�eriyor!");
			}
			if (str.trim().indexOf(" ") != -1) {// trim haricinde whitespace tespit ediyoruz
				throw new RuntimeException("Girilen string bo�luk karakterleri i�eriyor!");
			}
			str = str.trim().toLowerCase(); // trim ve lowercase yapt�ktan sonra for d�ng�s�ne al�yoruz
			if (str != null && !str.isEmpty()) { // null ya da empty olum olmama�sn� kontrol ediyoruz
				for (int i = 0; i < str.length(); i++) {
					for (int j = i + 1; j < str.length(); j++) {
						if (str.charAt(i) == str.charAt(j)) { // her bir harfi kendisinden sonraki kalan harfler ile
																// kar��la�t�r�yor ve e�er ayn� harf e denk gelirse uniq
																// olmad���na karar verip false d�n�yoruz
							return false;
						}
					}
				}
			} else {
				throw new RuntimeException("Girilen string null yada bo� olamaz!");
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile kar��la�t�m! > " + e);
		}
		return true;
	}

}
