
public class Endian {
public static byte[] convertEndign(byte[] pValue){
		
		byte[] convert = new byte[pValue.length];
		for (int i = 0; i < pValue.length; i++) {
			convert[i] = pValue[(pValue.length - 1) - i];
		}
		
		return convert;
	}
	
	
	/**
	 * Java�� ��� �÷������� ������ ǥ���� �� Big-Endian ����� ����Ѵ�. Little-Endian�� ����ϴ� �÷�������
	 * ���� ���������͸� ���� ��� Big-Endian���� ��ȯ�Ͽ� ����ؾ��Ѵ�. ������ �ڹٿ��� Big Little Endian��ȯ��
	 * �����ϴ� �����̴�.
	 */
	public static byte[] unsignedIntTobyteLittleEndian(long v) {
		byte[] buf = new byte[4];
		buf[3] = (byte) ((v >>> 24) & 0xFF);
		buf[2] = (byte) ((v >>> 16) & 0xFF);
		buf[1] = (byte) ((v >>> 8) & 0xFF);
		buf[0] = (byte) ((v >>> 0) & 0xFF);
		return buf;
	}

	/**
	 * Little-Endian ����Ʈ �迭�� �ڹٿ��� ����ϴ� Big-Endian������ ��ȯ�Ѵ�.
	 */
	public static int byteToUnsignedIntBigEndian(byte[] v) throws Exception {
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = (int) (v[3 - i] & 0xFF);
		}
		return ((arr[0] << 24) + (arr[1] << 16) + (arr[2] << 8) + (arr[3] << 0));
	}

	/**
	 * Little-Endian ����Ʈ �迭�� �ڹٿ��� ����ϴ� Big-Endian������ ��ȯ�Ѵ�.
	 */
	public static final short byteToShortBigEndian(byte[] buffer) {

		return byteToShort(buffer, 0);
	}

	public static final short byteToShort(byte[] buffer, int offset) {
		return (short) ((buffer[offset + 1] & 0xff) << 8 | (buffer[offset] & 0xff));
	}

	/**
	 * Little-Endian ����Ʈ �迭�� �ڹٿ��� ����ϴ� Big-Endian������ ��ȯ�Ѵ�.
	 */
	public static final byte[] ShortTobyteLittleEndian(short value) {

		return ShortTobyte(value);
	}

	public static final byte[] ShortTobyte(short value) {
		byte[] buf = new byte[2];
		buf[1] = (byte) ((value >>> 8) & 0xFF);
		buf[0] = (byte) ((value >>> 0) & 0xFF);
		return buf;
	}

	public static final byte[] setfloat(float f) {
		return setint(Float.floatToIntBits(f));
	}

	public static final byte[] setint(int i) {
		byte[] buf = new byte[4];

		buf[0] = (byte) (i >>> 24 & 0xff);
		buf[1] = (byte) (i >>> 16 & 0xff);
		buf[2] = (byte) (i >>> 8 & 0xff);
		buf[3] = (byte) (i & 0xff);

		return buf;
	}

	// ////////////////////

	/**
	 * Little-Endian ����Ʈ �迭�� �ڹٿ��� ����ϴ� Big-Endian������ ��ȯ�Ѵ�.
	 */
	public static final float byteToFloatBigEndian(byte[] buffer) {

		return byteToFloat(buffer, 0);
	}

	public static final float byteToFloat(byte[] buffer, int offset) {
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = (int) (buffer[3 - i] & 0xFF);
		}
		return ((arr[0] << 24) + (arr[1] << 16) + (arr[2] << 8) + (arr[3] << 0));
	}

	/**
	 * Little-Endian ����Ʈ �迭�� �ڹٿ��� ����ϴ� Big-Endian������ ��ȯ�Ѵ�.
	 */
	public static final byte[] FloatTobyteLittleEndian(int value) {

		return FloatTobyte(value);
	}

	public static final byte[] FloatTobyte(int value) {
		byte[] buf = new byte[2];
		buf[0] = (byte) ((value >>> 24) & 0xFF);
		buf[1] = (byte) ((value >>> 16) & 0xFF);
		buf[2] = (byte) ((value >>> 8) & 0xFF);
		buf[3] = (byte) ((value >>> 0) & 0xFF);
		return buf;
	}
	public static int Byte_To_UInt(byte _b) {
		return (int) _b & 0xFF;
	}
}
