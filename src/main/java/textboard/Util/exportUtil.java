package textboard.Util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class exportUtil {

	public static void writeFileContents(String filePath, int data) {
		writeFileContents(filePath, data + "");
	}

	public static void writeFileContents(String filePath, String contents) {
		BufferedOutputStream bs = null;
		try {
			bs = new BufferedOutputStream(new FileOutputStream(filePath));
			bs.write(contents.getBytes());
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			try {
				bs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void mkdirs(String path) {
		File dir = new File(path);

		if (dir.exists() == false) {
			dir.mkdirs();
		}
	}

	public static String getFileContents(String filePath) {
		String rs = null;
		try {
			FileInputStream fileStream = null;

			fileStream = new FileInputStream(filePath);

			byte[] readBuffer = new byte[fileStream.available()];
			while (fileStream.read(readBuffer) != -1) {

			}
			rs = new String(readBuffer);

			fileStream.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return rs;
	}

	public static void copy(String sourcePath, String destPath) {
		copy(new File(sourcePath), new File(destPath));
	}

	public static void copy(File sourceFile, File destFile) {
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getNowDateStr() {
		return new SimpleDateFormat("yyyy-MM--dd HH:mm:ss").format(new Date());
	}
}
