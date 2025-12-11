FILELAB REQUIRED METHODS AND THEIR FUNCTIONS
--------------------------------------------

1. Method:
   public static boolean fileExists(File f)

   Purpose:
   - Determine whether the given file exists on the file system.


2. Method:
   public static boolean fileIsReadable(File f)

   Purpose:
   - Determine whether the given file both exists and is readable.


3. Method:
   public static long fileSize(File f)

   Purpose:
   - Return the size of the given file in bytes.
   - If the file does not exist, indicate this by returning -1


4. Method:
   public static String fileName(File f)

   Purpose:
   - Return the name of the file (not its path).
   - Works whether the file exists or not.


5. Method:
   public static boolean deleteFile(File f)

   Purpose:
   - Attempt to delete the given file from the file system.
   - Return true if the deletion succeeds, false otherwise.


6. Method:
   public static boolean renameFile(File source, File target)

   Purpose:
   - Attempt to rename the source file to the target file name or path.
   - Return true if the rename succeeds, false otherwise.