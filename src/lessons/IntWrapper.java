package lessons;

/* Used in ShallowDeep lesson */
public class IntWrapper {
	int value;
	
	public IntWrapper(int v) {
		value = v;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
