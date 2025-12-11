## FileLab Instructions
In src/FileLab.java, implement the following methods using their listed purpose.

Implement using methods of the File class.



#### 1. public static boolean fileExists(File f)
   
   - Return whether the given file exists on the file system.


#### 2. public static boolean fileIsReadable(File f)

   - Determine whether the given file both exists and is readable.


#### 3. public static long fileSize(File f)

   - Return the size of the given file in bytes.
   - If the file does not exist, indicate this by returning -1


#### 4. public static String fileName(File f)

   - Return the name of the file (not its path).
   - Works whether the file exists or not.


#### 5. public static boolean deleteFile(File f)

   - Attempt to delete the given file from the file system.
   - Return true if the deletion succeeds, false otherwise.


#### 6. public static boolean renameFile(File source, File target)

   - Attempt to rename the source file to the target file name or path.
   - Return true if the rename succeeds, false otherwise.
