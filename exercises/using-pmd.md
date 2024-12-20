# Using PMD

Pick a Java project from Github (see the [instructions](../sujet.md) for suggestions). Run PMD on its source code using any ruleset (see the [pmd install instruction](./pmd-help.md)). Describe below an issue found by PMD that you think should be solved (true positive) and include below the changes you would add to the source code. Describe below an issue found by PMD that is not worth solving (false positive). Explain why you would not solve this issue.

## Answer

The result of my analisis for the commons-collections class is : 

D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\IterableUtils.java:627:  UnnecessaryFullyQualifiedName:  Unnecessary qualifier 'IterableUtils': 'isEmpty' is already in scope. :

### **Issues Found by PMD**


1. **Unnecessary Fully Qualified Name**

-  **Analysis**:  
   This is a **true positive**. Using fully qualified names where unnecessary reduces readability. The method `isEmpty` can be directly accessed since it's already in scope.

-  **Fix**:  
   Remove the qualifier `IterableUtils` to simplify the code.

-  **Original Code**:
   ```java
   return IterableUtils.isEmpty(iterable);
   ```

-  **Updated Code**:
   ```java
   return isEmpty(iterable);
   ```

---


D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bloomfilter\ArrayCountingBloomFilter.java:119:   UnusedPrivateMethod:    Avoid unused private methods such as 'add(int, int)'.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bloomfilter\ArrayCountingBloomFilter.java:280:   UnusedPrivateMethod:    Avoid unused private methods such as 'subtract(int, int)'.
2. **Unused private method**

-   **Analysis**:
    this is a **false positive**.   The `add(int, int)` and `subtract(int, int)` private methods are being used as method references in the `processCells` calls (`this::add` and `this::subtract`) inside the `add` and `subtract` public methods.
-   **Fix**:  
    Since the methods are being used we should use the annotation `@SuppressWarnings("PMD.UnusedPrivateMethod")`.

    ```java
    @SuppressWarnings("PMD.UnusedPrivateMethod") 
    private void add(int index, int value) {
        ...
    }
    
    @SuppressWarnings("PMD.UnusedPrivateMethod") 
    private void subtract(int index, int value) {
        ...
    }
    
    @Override
    public boolean add(final CellExtractor other) {
        Objects.requireNonNull(other, "other");
        other.processCells(this::add);
        return isValid();
    }
    
    @Override
    public boolean subtract(final CellExtractor other) {
        Objects.requireNonNull(other, "other");
        other.processCells(this::subtract);
        return isValid();
    }
    ```
---
