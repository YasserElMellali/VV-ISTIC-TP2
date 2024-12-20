package fr.istic.vv;

import com.github.javaparser.utils.SourceRoot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Should provide the path to the source code");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists() || !file.isDirectory() || !file.canRead()) {
            System.err.println("Provide a path to an existing readable directory");
            System.exit(2);
        }

        SourceRoot root = new SourceRoot(file.toPath());
        PublicElementsPrinter printer = new PublicElementsPrinter();

        // Parse the source files
        root.parse("", (localPath, absolutePath, result) -> {
            result.ifSuccessful(unit -> {
                // Inference of package name based on directory structure
                String packageName = file.toPath().relativize(localPath.getParent()).toString().replace(File.separator, ".");
                printer.setPackageName(packageName); // Set package name in the visitor
                unit.accept(printer, null); // Visit the unit
            });
            return SourceRoot.Callback.Result.DONT_SAVE;
        });

        // After processing all files, generate the report
        printer.generateReport();
    }
}
