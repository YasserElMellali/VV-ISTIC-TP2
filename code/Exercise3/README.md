# Code of your exercise

Put here all the code created for this exercise.

```xml
<?xml version="1.0"?>
<ruleset name="Custom Ruleset"
         xmlns="http://pmd.sourceforge.net/ruleset/2.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://pmd.sourceforge.net/ruleset/2.0.0
                             http://pmd.sourceforge.net/ruleset_2_0_0.xsd">

    <description>
        ruleset to detect complex code with three or more nested if statements.
    </description>

    <rule name="DetectNestedIfs"
          language="java"
          message="Avoid using three or more nested if statements."
          class="net.sourceforge.pmd.lang.rule.xpath.XPathRule">
        <priority>2</priority>
        <properties>
            <property name="x.-path">
                <value>
                    <![CDATA[
                        //IfStatement[
                            descendant::IfStatement[
                                descendant::IfStatement
                            ]
                        ]
                    ]]>
                </value>
            </property>
        </properties>
    </rule>

</ruleset>

```
---