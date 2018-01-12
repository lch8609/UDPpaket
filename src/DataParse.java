
public class DataParse {
	private Endian endian = new Endian();
	private byte[] buffer;
	private byte[][] dataBlock = new byte[12][100];
	
	public void putData(byte[] inBuffer) {
		buffer = inBuffer;
		//EndianConverter(buffer);
		byte[] val = java.nio.ByteBuffer.wrap(buffer).order(java.nio.ByteOrder.BIG_ENDIAN).array();
		DataParsing(val);
	}
	

	private void DataParsing(byte[] inBuffer) {
		for(int i=0; i<12; i++) {
			for(int j=0; j<100; j++) {
				dataBlock[i][j] = inBuffer[(i*100)+j];
			}
		}
	}
	
	public void printData() {
		System.out.println("\n");
		for(int i=0; i<dataBlock.length; i++) {
			System.out.println("DataBlock["+i+"] : "+converterHexa(dataBlock[i]));
		}
	}

	private StringBuilder converterHexa(byte[] buff) {
		StringBuilder sb = new StringBuilder();
	    for(final byte b: buff)
	        sb.append(String.format("%02x ", b&0xff));
	    return sb;
	}
}
