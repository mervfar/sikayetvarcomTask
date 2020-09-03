package main;

public class Quesiton2 {

	private static Quesiton2 question2;// private singleton nesnemiz

	private Quesiton2() { // Class'ýmýzý singleton ile oluþturduk

	}

	public static Quesiton2 getInstance() {// Class'ýmýzýn nesne aldýðýmýz methodu
		if (question2 == null) {
			return question2 = new Quesiton2();
		}

		return question2;
	}

	public boolean isUniq(String str) {
		System.out.println("2.Soru array vs. kullanýlmadan çözüm üretildi.");
		try {
			if (str.matches(".*\\d+.*")) { // regex ile sayý tespit ediyoruz
				throw new RuntimeException("Girilen string numara veya rakam içeriyor!");
			}
			if (str.matches(".*\\p{Punct}.*")) {// regex ile noktlama iþaretleri tespiti
				throw new RuntimeException("Girilen string noktalama iþaretleri içeriyor!");
			}
			if (str.trim().indexOf(" ") != -1) {// trim haricinde whitespace tespit ediyoruz
				throw new RuntimeException("Girilen string boþluk karakterleri içeriyor!");
			}
			str = str.trim().toLowerCase(); // trim ve lowercase yaptýktan sonra for döngüsüne alýyoruz
			if (str != null && !str.isEmpty()) { // null ya da empty olum olmamaýsný kontrol ediyoruz
				for (int i = 0; i < str.length(); i++) {
					for (int j = i + 1; j < str.length(); j++) {
						if (str.charAt(i) == str.charAt(j)) { // her bir harfi kendisinden sonraki kalan harfler ile
																// karþýlaþtýrýyor ve eðer ayný harf e denk gelirse uniq
																// olmadýðýna karar verip false dönüyoruz
							return false;
						}
					}
				}
			} else {
				throw new RuntimeException("Girilen string null yada boþ olamaz!");
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile karþýlaþtým! > " + e);
		}
		return true;
	}

}
