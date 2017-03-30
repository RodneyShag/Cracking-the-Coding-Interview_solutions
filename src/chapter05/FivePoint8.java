package chapter05;

/* Code is directly from book. Tricks:
 * 1) Set full bytes first
 * 2) Use masks for partial bits
 * 3) Special case: x1, x2 may be in same byte
 */
public class FivePoint8 {
	public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) { // I think width, x1, x2, y are all in pixels
		int start_offset = x1 % 8;
		int first_full_byte = x1 / 8;	// may change in next instruction
		if (start_offset != 0) {
			first_full_byte++;
		}
		int end_offset = x2 % 8;
		int last_full_byte = (x2 / 8) - 1;	// I think book makes off-by-1 error here. I fixed it.
		
		/* Darken Full Bytes */
		int bytesInRow = width / 8;
		int bytesToRow = bytesInRow * y;
		
		for (int b = first_full_byte; b <= last_full_byte; b++) {
			screen[bytesToRow + b] = (byte) 0xFF;
		}
		
		byte start_mask = (byte) (0xFF >> start_offset);
		byte end_mask = (byte) (0xFF << end_offset);

		if (x1 / 8 == x2 / 8) {	// then x1 and x2 are in same byte
			byte mask = (byte) (start_mask & end_mask);
			screen[bytesToRow + first_full_byte - 1] |= mask;
		} else {
			if (start_offset != 0) {
				screen[bytesToRow + first_full_byte - 1] |= start_mask;
			}
			if (end_offset != 0) {
				screen[bytesToRow + last_full_byte + 1] |= end_mask;
			}
		}
	}
}
