package main;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) {

		Question1 question1 = Question1.getInstance();// her bir soru için ayri class olusturdum
		Quesiton2 question2 = Quesiton2.getInstance();
		Question3 question3 = Question3.getInstance();

		System.out.println(question1.isUniq("omer"));

		System.out.println(question2.isUniq("omerr"));

		System.out.println(question3.SumForMe(95, 2));

	}

}
