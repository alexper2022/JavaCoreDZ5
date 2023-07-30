package rf.aleksper.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FilesBackUper {

	public static void backUpFiles(String path) {
		Path pathFiles = Path.of(path);
		new File(path + "/backup").mkdirs();
		Path backUpPath = Path.of(path + "/backup");
		try (Stream<Path> filesStream = Files.list(pathFiles)) {
			for (Path file : filesStream.toList()) {
				if (Files.isRegularFile(file)) {
					Files.copy(file, backUpPath.resolve(file.getFileName()), REPLACE_EXISTING);
				}
			}
			System.out.println("Файлы успешно скопированы из папки FilesBackUp в папку FilesBackUp/backup!");
		} catch (IOException e) {
			System.out.println("Путь указан неверно: " + path);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
