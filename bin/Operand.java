package bin;
//operand is the result of multiplication or division
public class Operand {
	private double value = 0;
	private void nextOperand(Num number) {
		number.next();
		value = number.getValue();
		char sgn = number.sign();
		while (sgn != '-' && sgn != '+' && sgn != '0') {
			number.next();
			switch(sgn) {
				case '*':
					value *= number.getValue();
					break;
				case '/':
					value /= number.getValue();
					break;
			}
			sgn = number.sign();
		}
	}
	public Operand(char[] str, boolean isRoman) {
		//if numbers are in roman format act like roman number
		if (isRoman) {
			RomanNumber number = new RomanNumber(str);
			nextOperand(number);
		} else { //if numbers are in arabic format act like roman number
			ArabicNumber number = new ArabicNumber(str);
			nextOperand(number);
		}
	}
	
	public double getValue() {
		return value;
	}

	public static void main(String[] args) {
		Operand op = new Operand("II*II*III-V".toCharArray(), true);
		System.out.println(op.getValue());
	}
}