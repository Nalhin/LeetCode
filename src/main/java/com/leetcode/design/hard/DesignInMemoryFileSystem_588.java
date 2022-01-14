package com.leetcode.design.hard;

// Design a data structure that simulates an in-memory file system.
//
// Implement the FileSystem class:
//
//
// FileSystem() Initializes the object of the system.
// List<String> ls(String path)
//
// If path is a file path, returns a list that only contains this file's name.
// If path is a directory path, returns the list of file and directory names in
// this directory.
//
// The answer should in lexicographic order.
// void mkdir(String path) Makes a new directory according to the given path.
// The given directory path does not exist. If the middle directories in the path do
// not exist, you should create them as well.
// void addContentToFile(String filePath, String content)
//
// If filePath does not exist, creates that file containing given content.
// If filePath already exists, appends the given content to original content.
//
//
// String readContentFromFile(String filePath) Returns the content in the file
// at filePath.
//
//
//
// Example 1:
//
//
// Input
// ["FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"]
//
// [[], ["/"], ["/a/b/c"], ["/a/b/c/d", "hello"], ["/"], ["/a/b/c/d"]]
// Output
// [null, [], null, null, ["a"], "hello"]
//
// Explanation
// FileSystem fileSystem = new FileSystem();
// fileSystem.ls("/");                         // return []
// fileSystem.mkdir("/a/b/c");
// fileSystem.addContentToFile("/a/b/c/d", "hello");
// fileSystem.ls("/");                         // return ["a"]
// fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"
//
//
//
// Constraints:
//
//
// 1 <= path.length, filePath.length <= 100
// path and filePath are absolute paths which begin with '/' and do not end
// with '/' except that the path is just "/".
// You can assume that all directory names and file names only contain
// lowercase letters, and the same names will not exist in the same directory.
// You can assume that all operations will be passed valid parameters, and
// users will not attempt to retrieve file content or list a directory or file that
// does not exist.
// 1 <= content.length <= 50
// At most 300 calls will be made to ls, mkdir, addContentToFile, and
// readContentFromFile.
//
// Related Topics Hash Table String Design Trie 👍 893 👎 112

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;
/*
  Runtime: 108 ms, faster than 6.06% of Java online submissions for Design In-Memory File System.
  Memory Usage: 52.7 MB, less than 7.44% of Java online submissions for Design In-Memory File System.
*/
public class DesignInMemoryFileSystem_588 {
  static class FileSystem {

    private final Directory rootDirectory = new Directory("/");

    private Iterator<String> pathIterator(String path) {
      List<String> tokenizedPath = Arrays.asList(path.split("/"));
      if (tokenizedPath.size() > 0) {
        return tokenizedPath.subList(1, tokenizedPath.size()).listIterator();
      }

      return Collections.emptyIterator();
    }

    public List<String> ls(String path) {
      return rootDirectory.visit(pathIterator(path)).stream().sorted().collect(Collectors.toList());
    }

    public void mkdir(String path) {
      rootDirectory.mkdir(pathIterator(path));
    }

    public void addContentToFile(String filePath, String content) {
      rootDirectory.addContent(content, pathIterator(filePath));
    }

    public String readContentFromFile(String filePath) {
      return rootDirectory.readContent(pathIterator(filePath));
    }

    interface FileSystemItem {

      List<String> visit(Iterator<String> pathIterator);

      String getName();

      void mkdir(Iterator<String> pathIterator);

      void addContent(String content, Iterator<String> pathIterator);

      String readContent(Iterator<String> pathIterator);
    }

    private static class File implements FileSystemItem {

      private final String name;
      private String content = "";

      private File(String name) {
        this.name = name;
      }

      @Override
      public List<String> visit(Iterator<String> pathIterator) {

        return List.of(name);
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public void mkdir(Iterator<String> pathIterator) {}

      @Override
      public void addContent(String content, Iterator<String> pathIterator) {
        this.content += content;
      }

      @Override
      public String readContent(Iterator<String> pathIterator) {

        return content;
      }
    }

    private static class Directory implements FileSystemItem {
      private final Map<String, FileSystemItem> items = new HashMap<>();
      private final String name;

      private Directory(String name) {
        this.name = name;
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public void mkdir(Iterator<String> pathIterator) {
        if (!pathIterator.hasNext()) {
          return;
        }
        items.computeIfAbsent(pathIterator.next(), Directory::new).mkdir(pathIterator);
      }

      @Override
      public void addContent(String content, Iterator<String> pathIterator) {

        String next = pathIterator.next();

        if (!pathIterator.hasNext()) {
          items.computeIfAbsent(next, File::new).addContent(content, pathIterator);
        } else {
          items.computeIfAbsent(next, Directory::new).addContent(content, pathIterator);
        }
      }

      @Override
      public String readContent(Iterator<String> pathIterator) {
        return items.get(pathIterator.next()).readContent(pathIterator);
      }

      @Override
      public List<String> visit(Iterator<String> pathIterator) {
        if (!pathIterator.hasNext()) {

          return items.values().stream().map(FileSystemItem::getName).collect(Collectors.toList());
        } else {
          String nextKey = pathIterator.next();
          if (!items.containsKey(nextKey)) {
            return Collections.emptyList();
          }
          return items.get(nextKey).visit(pathIterator);
        }
      }
    }
  }
}
/*
 * Your FileSystem object will be instantiated and called as such: FileSystem obj = new
 * FileSystem(); List<String> param_1 = obj.ls(path); obj.mkdir(path);
 * obj.addContentToFile(filePath,content); String param_4 = obj.readContentFromFile(filePath);
 */
// leetcode submit region end(Prohibit modification and deletion)
