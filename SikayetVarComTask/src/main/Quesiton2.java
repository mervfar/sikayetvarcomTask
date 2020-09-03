package main;

public class Quesiton2 {

	private static Quesiton2 question2;// private singleton nesnemiz

	private Quesiton2() { // Class ımızı singleton ile olusturduk

	}

	public static Quesiton2 getInstance() {// Class'ızın nesne aldigimiz methodu
		if (question2 == null) {
			return question2 = new Quesiton2();
		}

		return question2;
	}

	public boolean isUniq(String str) {
		System.out.println("2.Soru array vs. kullanýlmadan çözüm üretildi.");
		try {
			if (str.matches(".*\\d+.*")) { // regex ile sayi tespit ediyoruz
				throw new RuntimeException("Girilen string numara veya rakam iceriyor!");
			}
			if (str.matches(".*\\p{Punct}.*")) {// regex ile noktlama isaretleri tespiti
				throw new RuntimeException("Girilen string noktalama isaretleri iceriyor!");
			}
			if (str.trim().indexOf(" ") != -1) {// trim haricinde whitespace tespit ediyoruz
				throw new RuntimeException("Girilen string bosluk karakterleri iceriyor!");
			}
			str = str.trim().toLowerCase(); // trim ve lowercase yaptiktan sonra for dongusune aliyoruz
			if (str != null && !str.isEmpty()) { // null ya da empty olum olmamasini kontrol ediyoruz
				for (int i = 0; i < str.length(); i++) {
					for (int j = i + 1; j < str.length(); j++) {
						if (str.charAt(i) == str.charAt(j)) { // her bir harfi kendisinden sonraki kalan harfler ile karsilastiriyor ve eger ayni harf e denk gelirse uniq olmadigina karar verip false donuyoruz
							return false;
						}
					}
				}
			} else {
				throw new RuntimeException("Girilen string null yada bos olamaz!");
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile karsilastim! > " + e);
		}
		return true;
	}

}
