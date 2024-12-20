package fr.istic.vv;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorWithDefaults;

import java.util.HashMap;
import java.util.Map;

public class PublicElementsPrinter extends VoidVisitorWithDefaults<Void> {

    // To store the private fields and their respective classes
    private final Map<String, String> privateFieldsWithoutGetters = new HashMap<>();
    private String packageName; // Store the package name here

    // Setter for package name
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void visit(CompilationUnit unit, Void arg) {
        for (TypeDeclaration<?> type : unit.getTypes()) {
            type.accept(this, null);
        }
    }

    // Method to visit class or interface declarations
    public void visitTypeDeclaration(TypeDeclaration<?> declaration, Void arg) {
        if (!declaration.isPublic()) return;

        // Visit all members in the class (fields and methods)
        Map<String, MethodDeclaration> getters = new HashMap<>();
        for (MethodDeclaration method : declaration.getMethods()) {
            if (method.isPublic() && method.getNameAsString().startsWith("get")) {
                getters.put(method.getNameAsString().toLowerCase(), method);
            }
        }

        // Look for private fields and check if they have a getter
        for (BodyDeclaration<?> member : declaration.getMembers()) {
            if (member instanceof FieldDeclaration) {
                FieldDeclaration field = (FieldDeclaration) member;
                for (VariableDeclarator var : field.getVariables()) {
                    // Check for private fields
                    if (field.isPrivate()) {
                        String fieldName = var.getNameAsString().toLowerCase();
                        if (!getters.containsKey("get" + fieldName)) {
                            // If no getter is found, add to the report map
                            privateFieldsWithoutGetters.put(fieldName, declaration.getNameAsString());
                        }
                    }
                }
            }
        }

        // Printing nested types in the top level
        for (BodyDeclaration<?> member : declaration.getMembers()) {
            if (member instanceof TypeDeclaration)
                member.accept(this, arg);
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration declaration, Void arg) {
        visitTypeDeclaration(declaration, arg);
    }

    @Override
    public void visit(EnumDeclaration declaration, Void arg) {
        visitTypeDeclaration(declaration, arg);
    }

    // Output the private fields that don't have getters
    public void generateReport() {
        System.out.println("Field Name, Class Name, Package Name");
        for (Map.Entry<String, String> entry : privateFieldsWithoutGetters.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue() + ", " + packageName);
        }
    }
}
