
1. Write class telran.io.FileUtils with the following method
`public static void displayDirectoryContent(Path path, int depth)`

```
prints directory structure of the given path directory and depth
if depth equals 0 it prints all directory structure from the given start
output:
 dir_name       level 1
     file_name
     ......
     dir_name
         file_name level 2
         ....
         dir_name
            ......    level 3
```

1. Create performance test for copying large (more 2Gb) files similar to design we did in the previous similar projects. Note: similar doesn’t mean the exactly the same code but it does mean the same Object Oriented approach  
   - One implementation of the copying should be based on the static method copy of the Java standard class Files 
   - Other implementation of the copying should be based on the InputStream and OutputSream as we have done at classwork but take into consideration that it is impossible to use buffer for getting whole big file by one read action
     1. This implementation should be ran with the different sizes of the buffer (array of bytes). For example, as follows 
        - 100 bytes 
        - 100 Mb 
        - Runtime.getRuntime().freeMemory() 
 Implementation notes: consider using the following methods of Input/Output streams (called in while loop) 
int read(byte[] buffer) – returns amount of the being read bytes and write( byte[] buffer, int offset, int length) 
