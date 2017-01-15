package chapter10;
/* Used in 10.4 */
public class BitSet {
	int [] bitset;
	
	public BitSet(int size){
		bitset = new int [size/32];
	}
	
	public boolean get(int pos){
		int wordNumber = pos / 32;
		int bitNumber = pos % 32;
		return (bitset[wordNumber] & (1 << bitNumber)) != 0;
	}
	
	public void set(int pos){
		int wordNumber = pos / 32;
		int bitNumber = pos % 32;
		bitset[wordNumber] |= (1 << bitNumber);
	}
}

//this is an implementation of java.util.BitSet !!