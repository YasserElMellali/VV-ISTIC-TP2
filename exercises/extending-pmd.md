# Extending PMD

Use XPath to define a new rule for PMD to prevent complex code. The rule should detect the use of three or more nested `if` statements in Java programs so it can detect patterns like the following:

```Java
if (...) {
    ...
    if (...) {
        ...
        if (...) {
            ....
        }
    }

}
```
Notice that the nested `if`s may not be direct children of the outer `if`s. They may be written, for example, inside a `for` loop or any other statement.
Write below the XML definition of your rule.

You can find more information on extending PMD in the following link: https://pmd.github.io/latest/pmd_userdocs_extending_writing_rules_intro.html, as well as help for using `pmd-designer` [here](https://github.com/selabs-ur1/VV-ISTIC-TP2/blob/master/exercises/designer-help.md).

Use your rule with different projects and describe you findings below. See the [instructions](../sujet.md) for suggestions on the projects to use.

## Answer

I've applied the custom PMD rule that I've created to the `commons-collections` project and identified multiple instances of code with three or more nested `if` statements. Below are the locations where these complex condition structures were detected:

```
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\CollectionUtils.java:1858:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\CollectionUtils.java:1860:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\CollectionUtils.java:1862:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\CollectionUtils.java:1864:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\MapUtils.java:227:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\MapUtils.java:927:       DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\MapUtils.java:1662:      DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\MapUtils.java:1668:      DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\MapUtils.java:1985:      DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:1153:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:1217:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:1238:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:1277:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:1361:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:2107:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bidimap\TreeBidiMap.java:2132:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\bloomfilter\BloomFilter.java:158:        DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\comparators\ComparatorChain.java:205:    DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\iterators\CollatingIterator.java:271:    DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\iterators\ObjectGraphIterator.java:242:  DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\list\CursorableLinkedList.java:188:      DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\AbstractReferenceMap.java:316:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\CompositeMap.java:194:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\ConcurrentReferenceHashMap.java:837: DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\ConcurrentReferenceHashMap.java:960: DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\ConcurrentReferenceHashMap.java:1024:        DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\Flat3Map.java:612:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\Flat3Map.java:814:   DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\Flat3Map.java:938:   DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\Flat3Map.java:1068:  DetectNestedIfs:        Avoid using three or more nested if statements.   
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\map\LRUMap.java:241:     DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\sequence\SequencesComparator.java:187:   DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\set\CompositeSet.java:193:       DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\trie\AbstractPatriciaTrie.java:1640:     DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\trie\AbstractPatriciaTrie.java:1989:     DetectNestedIfs:        Avoid using three or more nested if statements.
D:\Master\VV\commons-collections\src\main\java\org\apache\commons\collections4\trie\AbstractPatriciaTrie.java:2041:     DetectNestedIfs:        Avoid using three or more nested if statements.
---