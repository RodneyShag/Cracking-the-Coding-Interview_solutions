package chapter10;

/* For fun, I tried implementing java.util.BitSet on my own */
public class MyBitSet{
	private static final int BITS_IN_INT = 32;
	private int [] bitset;
	
	public MyBitSet(int size) throws NegativeArraySizeException{
		if (size < 0)
			throw new NegativeArraySizeException();
		bitset = new int [size/BITS_IN_INT];
	}
	
	/* I needed this constructor for 10.3. Long enables me to make HUGE arrays */
	public MyBitSet(long size) throws NegativeArraySizeException{
		if (size < 0)
			throw new NegativeArraySizeException();
		bitset = new int [(int) (size/BITS_IN_INT)];
	}
	
	public boolean get(int pos) throws IndexOutOfBoundsException{
		if (pos < 0)
			throw new IndexOutOfBoundsException();
		int wordNumber = pos / BITS_IN_INT;
		int bitNumber  = pos % BITS_IN_INT;
		if (wordNumber >= bitset.length)
			throw new IndexOutOfBoundsException();
		return (bitset[wordNumber] & (1 << bitNumber)) != 0;
	}
	
	public void set(int pos) throws IndexOutOfBoundsException{
		if (pos < 0)
			throw new IndexOutOfBoundsException();
		int wordNumber = pos / BITS_IN_INT;
		int bitNumber  = pos % BITS_IN_INT;
		if (wordNumber >= bitset.length)
			throw new IndexOutOfBoundsException();
		bitset[wordNumber] |= (1 << bitNumber);
	}
	
	public int size(){
		return bitset.length / BITS_IN_INT;
	}
}
