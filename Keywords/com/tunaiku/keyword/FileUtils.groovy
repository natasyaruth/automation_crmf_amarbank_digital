package com.tunaiku.keyword

class FileUtils {

	public static String toBase64(File file) throws IOException {
		FileInputStream fileInputStreamReader = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		fileInputStreamReader.read(bytes);
		return Base64.getEncoder().encodeToString(bytes);
	}
}