import java.util.*;

class ATMinterface {

    String Name;
    String Holder_name;
    int Pin;
    int Account_number;
    float Balance = 10000f;
    int Transactions = 0;
    String Transaction_history = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.Name = sc.nextLine();
        System.out.print("\nEnter Your Holder_name - ");
        this.Holder_name = sc.nextLine();
        System.out.print("\nEnter Your Pin - ");
        this.Pin = sc.nextInt();
        System.out.print("\nEnter Your Account_number - ");
        this.Account_number = sc.nextInt();
        System.out.print("\nRegistration completed. \nLogin");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEnter Your Holder_name - ");
            String holder_name = sc.nextLine();
            if (holder_name.equals(Holder_name)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Pin - ");
                    int pin = sc.nextInt();
                    if (pin == Pin) {
                        System.out.print("\nLogin Successful!! ");
                        isLogin = true;
                    } else {
                        System.out.print("\nIncorrect Pin");
                    }
                }
            } else {
                System.out.print("\nHolder_name not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to be withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
    
            if (Balance >= amount) {
                Transactions++;
                Balance -= amount;
                System.out.print("\nWithdraw Successfully");
                String str = amount + "Rs Withdrawn\n";
                Transaction_history = Transaction_history.concat(str);
            } else {
                System.out.print("\nInsufficient Balance");
            }
        

        }
    

    public void deposit() {
        System.out.print("\nEnter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float Amount = sc.nextFloat();

        
            if (Amount <= 10000f) {
                Transactions++;
                Balance += Amount;
                System.out.print("\nSuccessfully Deposited");
                String str = Amount + " Rs Deposited\n";
                Transaction_history = Transaction_history.concat(str);
            } else {
                System.out.print("\nSorry....Limit is 10000.00");
            }
        
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name - ");
        String Recipient = sc.nextLine();
        System.out.print("\nEnter Amount to Transfer - ");
        float Amount = sc.nextFloat();

            if (Balance >= Amount) {
                if (Amount <= 10000f) {
                    Transactions++;
                    Balance -= Amount;
                    System.out.print("\nSuccessfully Transfered to " + Recipient);
                    String str = Amount + " Rs Transfered to " + Recipient + "\n";
                    Transaction_history = Transaction_history.concat(str);
                } else {
                    System.out.print("\nSorry....Limit is 10000");
                }
            } else {
                System.out.print("\nInsufficient Balance");
            }

        }

        
    public void transaction_History() {
        if (Transactions == 0) {
            System.out.print("\nEmpty");
        } else {
            System.out.print("\n" + Transaction_history);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMinterface atm = new ATMinterface();

        int choice;
        boolean loggedIn = false;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Transfer");
            System.out.println("6. Transaction History");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.register();
                    break;
                case 2:
                    loggedIn = atm.login();
                    break;
                case 3:
                    if (loggedIn) {
                        atm.withdraw();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    if (loggedIn) {
                        atm.deposit();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 5:
                    if (loggedIn) {
                        atm.transfer();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 6:
                    if (loggedIn) {
                        atm.transaction_History();
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);
    }
}


