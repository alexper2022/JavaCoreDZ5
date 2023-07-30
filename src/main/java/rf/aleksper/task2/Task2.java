package rf.aleksper.task2;

import java.util.Arrays;
import java.util.Random;

public class Task2 {

	public static void task2() {
		// Исходный массив состояний ячеек
		// (9 элементов, каждый в диапазоне
		// [0, 2] (3 зарезервировано))
		int[] intsArrayOut = new Random()
				.ints(9, 0, 3)
				.toArray();
		System.out.println("\nСгенерирован массив int[]:\n" + Arrays.toString(intsArrayOut));
		System.out.println("\nСохраняем массив в файл.");
		try {
			IO.arrayToFileWriter(intsArrayOut);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\nСчитываем массив из файла.");
		int[] newIntArray = null;
		try {
			newIntArray = IO.arrayFromFileReader();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println((Arrays.toString(newIntArray)));

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < newIntArray.length - 1; i++) {
			if (newIntArray[i] == 0) {
				stringBuilder.append(" ");
			} else if (newIntArray[i] == 1) {
				stringBuilder.append("X");
			} else if (newIntArray[i] == 2) {
				stringBuilder.append("O");
			}
			// после 3 и 6 элемента вставляем перенос строки
			if (i == 2 || i == 5) stringBuilder.append("\n");
		}
		String str = stringBuilder.toString();
		System.out.println("\nВыводим игровое поле на экран:\n");
		System.out.println(str);
	}
}

