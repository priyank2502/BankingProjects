
public class MobilePhone {

	public static void main(String[] args) {
		Mobile m1 = new Mobile();
		m1.printModel("iPHONE", "PRO", "Gold", 80000);

		Mobile m2 = new Mobile();
		m2.printModel("Samsung", "A50", "Black", 50000);

		Mobile m3 = new Mobile();
		m3.printModel("Oppo", "F51", "White", 10000);
	}

}

class Mobile {
	String brand;
	String model;
	String color;
	int price;

	void printModel(String b, String m, String c, int p) {
		if (b == null) {
			throw new RuntimeException("The brand name is not null......");
		} else {
			brand = b;
		}
		if (m == null) {
			throw new RuntimeException("The model name is not null......");
		} else {
			model = m;
		}
		if (c == null) {
			throw new RuntimeException("The color is not null......");
		} else {
			color = c;
		}

		System.out.println(" The brand name is....." + b);
		System.out.println(" The model name is....." + m);
		System.out.println(" The color is....." + c);
		System.out.println(" The cost is...... " + p);
	}
}
