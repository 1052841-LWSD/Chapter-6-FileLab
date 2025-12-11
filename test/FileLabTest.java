import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLabTest {

    // Helper: create a temp file with content
    private File createTempFile(String name, String data) throws IOException {
        File temp = File.createTempFile(name, ".tmp");
        FileWriter fw = new FileWriter(temp);
        fw.write(data);
        fw.close();
        temp.deleteOnExit();
        return temp;
    }

    // -----------------------------
    // fileExists(File f)
    // -----------------------------
    @Test
    public void testFileExists_True() throws IOException {
        File temp = createTempFile("existsTest", "hello");
        assertTrue(FileLab.fileExists(temp));
    }

    @Test
    public void testFileExists_False() {
        File missing = new File("not_a_real_file_12345.txt");
        assertFalse(FileLab.fileExists(missing));
    }

    // -----------------------------
    // fileIsReadable(File f)
    // -----------------------------
    @Test
    public void testFileIsReadable_True() throws IOException {
        File temp = createTempFile("readTest", "abc");
        assertTrue(FileLab.fileIsReadable(temp));
    }

    @Test
    public void testFileIsReadable_False_DoesNotExist() {
        File missing = new File("ghostfile_9977.txt");
        assertFalse(FileLab.fileIsReadable(missing));
    }

    // -----------------------------
    // fileSize(File f)
    // -----------------------------
    @Test
    public void testFileSize_Correct() throws IOException {
        File temp = createTempFile("sizeTest", "123456"); // 6 bytes
        assertEquals(6, FileLab.fileSize(temp));
    }

    @Test
    public void testFileSize_DoesNotExist() {
        File missing = new File("random_missing_file_2222.txt");
        assertEquals(-1, FileLab.fileSize(missing));
    }

    // -----------------------------
    // fileName(File f)
    // -----------------------------
    @Test
    public void testFileName_ExistingFile() throws IOException {
        File temp = createTempFile("nameTest", "text");
        assertEquals(temp.getName(), FileLab.fileName(temp));
    }

    @Test
    public void testFileName_NonexistentFile() {
        File missing = new File("fake_name.txt");
        assertEquals("fake_name.txt", FileLab.fileName(missing));
    }

    // -----------------------------
    // deleteFile(File f)
    // -----------------------------
    @Test
    public void testDeleteFile() throws IOException {
        File temp = createTempFile("deleteTest", "data");
        assertTrue(temp.exists());

        assertTrue(FileLab.deleteFile(temp));
        assertFalse(temp.exists());
    }

    @Test
    public void testDeleteFile_Nonexistent() {
        File missing = new File("delete_missing_0001.txt");
        assertFalse(FileLab.deleteFile(missing));
    }

    // -----------------------------
    // renameFile(File source, File target)
    // -----------------------------
    @Test
    public void testRenameFile() throws IOException {
        File source = createTempFile("renameSource", "abc");

        File target = new File(source.getParent(), "renamed_output.tmp");
        if (target.exists()) target.delete();

        boolean success = FileLab.renameFile(source, target);
        assertTrue(success);

        assertFalse(source.exists());
        assertTrue(target.exists());

        target.deleteOnExit();
    }

    @Test
    public void testRenameFile_SourceMissing() throws IOException {
        File missing = new File("missing_rename_5544.txt");

        File target = File.createTempFile("target", ".tmp");
        target.deleteOnExit();

        assertFalse(FileLab.renameFile(missing, target));
    }
}