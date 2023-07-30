package rf.aleksper.task2;

import java.io.*;

public class IO {

	public static void arrayToFileWriter(int[] arrInt) throws IOException {
		FileOutputStream fs = new FileOutputStream("TicTacToeSave.dat");
		DataOutputStream ds = new DataOutputStream(fs);
		ds.writeInt(arrInt.length);
		for (int j : arrInt) ds.writeInt(j);
		fs.close();
		System.out.println("Данные успешно записаны в файл!");
	}

	public static int[] arrayFromFileReader() throws IOException {

		FileInputStream fs2 = new FileInputStream("TicTacToeSave.dat");

		DataInputStream ds2 = new DataInputStream(fs2);

		int count = ds2.readInt();

		int[] result = new int[count];

		for (int i = 0; i < result.length; i++)
			result[i] = ds2.readInt();

		ds2.close();
		System.out.println("Данные успешно считаны из файла!");
		return result;
	}
}
