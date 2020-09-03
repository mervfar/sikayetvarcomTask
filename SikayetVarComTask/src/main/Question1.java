package main;

import java.util.HashMap;

@SuppressWarnings("unused") // ide için warning kapatma ayarý
public class Question1 {

	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private HashMap<String, Boolean> letters = new HashMap<String, Boolean>(); // key=harf value=boolean olan bir
																				// hashmap belirledik

	private static Question1 question1;// private singleton nesnemiz

	private Question1() { // Class'ýmýzý singleton ile oluþturduk

	}

	public static Question1 getInstance() {// Class'ýmýzýn nesne aldýðýmýz methodu
		if (question1 == null) {
			return question1 = new Question1();
		}

		return question1;
	}

	public boolean isUniq(String s) { // uniq testi yapan method

		System.out.println("1.Soru array kullanýlarak çözüm yolu üretildi.");
		try {
			if (s.matches(".*\\d+.*")) { // regex ile sayý tespiti
				throw new RuntimeException("Girilen string numara veya rakam içeriyor!");
			}
			if (s.matches(".*\\p{Punct}.*")) {// regex ile noktlama iþaretleri tespiti
				throw new RuntimeException("Girilen string noktalama iþaretleri içeriyor!");
			}
			if (s.trim().indexOf(" ") != -1) {// trim haricinde whitespace var mý yok mu
				throw new RuntimeException("Girilen string boþluk karakterleri içeriyor!");
			}
			setMap(); // hashmap hazýrlama methodumuzu çaðýrdýk
			String[] arrayToCheck = s.toLowerCase().trim().split("");
			// input dan gelen string uppercase olma ihtimaline karþý lowercase uyguladýk ve
			// boþluklarý trim yaptýk

			for (String check : arrayToCheck) { // inputtan gelen her bir harfi kontrol ediyoruz sýrasýyla

				if (!letters.get(check)) {
					letters.put(check, true); // eðer hashmap içinde karþýsýndaki deðer false ise ben bunu kullandým
												// diyerek
												// true deðerine çekiyoruz
				} else { // eðer kontrol ederken true deðerine denk gelirsek, bu harfin daha önceden
							// kullanýldýðýný anlayýp false dönüyoruz
					return false;
				}
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile karþýlaþtým! > " + e);
		}
		return true;
	}

	private void setMap() {// en baþta hashmap'in içini alfabe ile doldurup deðerlerini false yaptýk
		String[] letterArray = alphabet.split("");
		for (String s : letterArray) {
			letters.put(s, false);
		}

	}

}
