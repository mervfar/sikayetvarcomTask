package main;

import java.util.HashMap;

@SuppressWarnings("unused") // ide i�in warning kapatma ayar�
public class Question1 {

	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private HashMap<String, Boolean> letters = new HashMap<String, Boolean>(); // key=harf value=boolean olan bir
																				// hashmap belirledik

	private static Question1 question1;// private singleton nesnemiz

	private Question1() { // Class'�m�z� singleton ile olu�turduk

	}

	public static Question1 getInstance() {// Class'�m�z�n nesne ald���m�z methodu
		if (question1 == null) {
			return question1 = new Question1();
		}

		return question1;
	}

	public boolean isUniq(String s) { // uniq testi yapan method

		System.out.println("1.Soru array kullan�larak ��z�m yolu �retildi.");
		try {
			if (s.matches(".*\\d+.*")) { // regex ile say� tespiti
				throw new RuntimeException("Girilen string numara veya rakam i�eriyor!");
			}
			if (s.matches(".*\\p{Punct}.*")) {// regex ile noktlama i�aretleri tespiti
				throw new RuntimeException("Girilen string noktalama i�aretleri i�eriyor!");
			}
			if (s.trim().indexOf(" ") != -1) {// trim haricinde whitespace var m� yok mu
				throw new RuntimeException("Girilen string bo�luk karakterleri i�eriyor!");
			}
			setMap(); // hashmap haz�rlama methodumuzu �a��rd�k
			String[] arrayToCheck = s.toLowerCase().trim().split("");
			// input dan gelen string uppercase olma ihtimaline kar�� lowercase uygulad�k ve
			// bo�luklar� trim yapt�k

			for (String check : arrayToCheck) { // inputtan gelen her bir harfi kontrol ediyoruz s�ras�yla

				if (!letters.get(check)) {
					letters.put(check, true); // e�er hashmap i�inde kar��s�ndaki de�er false ise ben bunu kulland�m
												// diyerek
												// true de�erine �ekiyoruz
				} else { // e�er kontrol ederken true de�erine denk gelirsek, bu harfin daha �nceden
							// kullan�ld���n� anlay�p false d�n�yoruz
					return false;
				}
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile kar��la�t�m! > " + e);
		}
		return true;
	}

	private void setMap() {// en ba�ta hashmap'in i�ini alfabe ile doldurup de�erlerini false yapt�k
		String[] letterArray = alphabet.split("");
		for (String s : letterArray) {
			letters.put(s, false);
		}

	}

}
