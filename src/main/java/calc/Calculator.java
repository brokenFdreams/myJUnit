package calc;

public class Calculator {
	public int calculate(String str) {
		if (str != null) {
			String[] tmp = str.split(" ");
			if (tmp.length != 3)
				return 0;
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[2]);
			return calc(tmp[1].toCharArray()[0], a, b);
		}
		return 0;
	}

	private int calc(char sign, int a, int b) {
		switch (sign) {
			case '+' : return a + b;
			case '-' : return a - b;
			case '/' : return a / b;
			case '*' : return a * b;
			case '%' : return a % b;
		}
		return 0;
	}
}
