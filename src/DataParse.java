
public class DataParse {
	private byte[] buffer;
	private byte[] header = new byte[42];
	private byte[][] dataBlock = new byte[12][100];
	private byte[] timeStamp = new byte[4];
	private byte[] factory = new byte[2];
	
	public void putData(byte[] inBuffer) {
		buffer = inBuffer;
		DataParsing(buffer);
	}

	private void DataParsing(byte[] inBuffer) {
		byte[] buff = new byte[1200];
		for(int i=0; i<inBuffer.length; i++) {
			if(i<42) {	//header
				header[i] = inBuffer[i];
			}else if(i<1242) {	// datablock
				buff[i-42] = inBuffer[i];
			}else if(i<1246) {	// timestamp
				timeStamp[i-1242] = inBuffer[i];
			}else {	//factory
				factory[i-1246] = inBuffer[i];
			}
		}
		
		for(int i=0; i<12; i++) {
			for(int j=0; j<100; j++) {
				dataBlock[i][j] = buff[(i*100)+j];
			}
		}
	}
	
	public void printData() {
		System.out.println("Header : "+converterHexa(header));
		for(int i=0; i<dataBlock.length; i++) {
			System.out.println("DataBlock["+i+"] : "+converterHexa(dataBlock[i]));
		}
		System.out.println("TimeStamp : "+converterHexa(timeStamp));
		System.out.println("Factory : "+converterHexa(factory));
	}
	
	private StringBuilder converterHexa(byte[] buff) {
		StringBuilder sb = new StringBuilder();
	    for(final byte b: buff)
	        sb.append(String.format("%02x ", b&0xff));
	    return sb;
	}
}
