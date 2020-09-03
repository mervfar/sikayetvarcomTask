package main;

import java.util.HashMap;

@SuppressWarnings("unused") // ide için warning kapatma ayarı
public class Question1 {

	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private HashMap<String, Boolean> letters = new HashMap<String, Boolean>(); // key=harf value=boolean olan bir hashmap belirledik

	private static Question1 question1;// private singleton nesnemiz

	private Question1() { // Class'ımızı singleton ile oluşturduk

	}

	public static Question1 getInstance() {// Class'ımızın nesne aldığımız methodu
		if (question1 == null) {
			return question1 = new Question1();
		}

		return question1;
	}

	public boolean isUniq(String s) { // uniq testi yapan method

		System.out.println("1.Soru array kullanılarak çözüm yolu üretildi.");
		try {
			if (s.matches(".*\\d+.*")) { // regex ile sayı tespiti
				throw new RuntimeException("Girilen string numara veya rakam içeriyor!");
			}
			if (s.matches(".*\\p{Punct}.*")) {// regex ile noktlama işaretleri tespiti
				throw new RuntimeException("Girilen string noktalama işaretleri içeriyor!");
			}
			if (s.trim().indexOf(" ") != -1) {// trim haricinde whitespace var mı yok mu
				throw new RuntimeException("Girilen string boşluk karakterleri içeriyor!");
			}
			setMap(); // hashmap hazırlama methodumuzu çağırdık
			String[] arrayToCheck = s.toLowerCase().trim().split("");
			// input dan gelen string uppercase olma ihtimaline karşı lowercase uyguladık ve
			// boşlukları trim yaptık

			for (String check : arrayToCheck) { // inputtan gelen her bir harfi kontrol ediyoruz sırasıyla

				if (!letters.get(check)) {
					letters.put(check, true); // eğer hashmap içinde karşısındaki değer false ise ben bunu kullandım diyerek  true değerine çekiyoruz
				} else { // eğer kontrol ederken true değerine denk gelirsek, bu harfin daha önceden kullanıldığını anlayıp false dönüyoruz
					return false;
				}
			}

		} catch (Exception e) {
			throw new RuntimeException("Bir hata ile karşılaştım! > " + e);
		}
		return true;
	}

	private void setMap() {// en başta hashmap'in içini alfabe ile doldurup değerlerini false yaptık
		String[] letterArray = alphabet.split("");
		for (String s : letterArray) {
			letters.put(s, false);
		}

	}

}
