# TCC *vs* LCC

Explain under which circumstances *Tight Class Cohesion* (TCC) and *Loose Class Cohesion* (LCC) metrics produce the same value for a given Java class. Build an example of such as class and include the code below or find one example in an open-source project from Github and include the link to the class below. Could LCC be lower than TCC for any given class? Explain.

A refresher on TCC and LCC is available in the [course notes](https://oscarlvp.github.io/vandv-classes/#cohesion-graph).

## Answer

### **TCC = LCC**

```java
public class BankAccount {
    private double balance;
    private String accountName;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountHolderName;
    }
}
```

In this class all methods directly interact with common attributes:

1. Methods `deposit`, `withdraw`, and `getBalance` interact directly with `balance`.
2. Method `getAccountName` interacts directly with `accountName`.

Every pair of methods either directly shares an attribute or does not share at all.(no indirect connections exist).

---

### **LCC < TCC**

No, it is impossible for LCC to be lower than TCC for any given class , since TCC counts only direct connections and 
LCC includes both direct and indirect connections.
So LCC has to be >= TCC.

---